package com.project.informationhub.integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MediaTypeIntegrationTest {
	@Autowired
    private MockMvc mvc;
	
	@Test
    public void createMediaTypeTest()   throws Exception {    
		
    	mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"pdf\"}")).andExpect(
						status().isOk()).andExpect(jsonPath("$.mediaTypeName").value("pdf")) .andReturn();	
    }
	
	@Test
    public void findAllTest()   throws Exception { 
		
		mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"pdf\"}"));
		
		mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"mp3\"}"));
		
		mvc.perform(get("/mediatype").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].mediaTypeName").value("pdf"))
    	.andExpect(jsonPath("$[1].mediaTypeName").value("mp3"));
		
	
	}
}
