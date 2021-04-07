package com.project.informationhub.integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class RoleIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	String sampleRequest;
	
	@Test
	public void createRoleTest() throws Exception {
		
		sampleRequest = "{\"name\" : \"admin\""+ "\r\n" +  "}";
		
		mvc.perform(post("/roles").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andExpect(jsonPath("$.name").value("admin")) .andReturn();
		
	}
	
	
	@Test
	public void getRoleTest() throws Exception {
		
		sampleRequest = "{\"name\" : \"admin\""+ "\r\n" +  "}";
		
		MvcResult mvcResult = mvc.perform(post("/roles").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andExpect(jsonPath("$.name").value("admin")) .andReturn();
		
		JSONObject roleResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = roleResponse.getLong("id");
		
		mvc.perform(get("/roles/"+ id).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.name").value("admin"));
		
	}

}
