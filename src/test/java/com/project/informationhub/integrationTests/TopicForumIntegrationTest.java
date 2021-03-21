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
public class TopicForumIntegrationTest {
	
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void createTopicTest()   throws Exception {    

    	mvc.perform(post("/topicforum").contentType(MediaType.APPLICATION_JSON).content(
				"{\"title\": \"Covid New Variants\"}")).andExpect(
						status().isOk()).andExpect(jsonPath("$.title").value("Covid New Variants")) .andReturn();
	
    }
    
    @Test
    public void findAllTest()   throws Exception {   
 
    	mvc.perform(post("/topicforum").contentType(MediaType.APPLICATION_JSON).content(
				"{\"title\": \"Covid New Variants\"}"));
    	
    	mvc.perform(post("/topicforum").contentType(MediaType.APPLICATION_JSON).content(
				"{\"title\": \"Covid New Vaccines\"}"));
    	
    	mvc.perform(get("/topicforum").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].title").value("Covid New Variants"))
    	.andExpect(jsonPath("$[1].title").value("Covid New Vaccines"));
    		
    }


}
