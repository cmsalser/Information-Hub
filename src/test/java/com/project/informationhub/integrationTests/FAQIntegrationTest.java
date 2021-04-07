package com.project.informationhub.integrationTests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import org.springframework.web.util.NestedServletException;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FAQIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	String sampleRequest;
	
	@Test
	public void newFAQTest() throws Exception {
		sampleRequest = "{\"question\" : \"When will Covid Pandemic end\""+ ",\r\n" + 
				"  \"answer\" : \"2022\"\r\n" + "}";
		
		mvc.perform(post("/FAQ").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.answer").value("2022")) .andReturn();
	}
	
	@Test
	public void oneTest() throws Exception {
		sampleRequest = "{\"question\" : \"When will Covid Pandemic end\""+ ",\r\n" + 
				"  \"answer\" : \"2022\"\r\n" + "}";
		
		MvcResult mvcResult =  mvc.perform(post("/FAQ").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andExpect(jsonPath("$.answer").value("2022")) .andReturn();
		
		JSONObject faqResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = faqResponse.getLong("id");		
		
		
		mvc.perform(get("/FAQ/"+ id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.answer").value("2022")) .andReturn();
	}
	
	@Test
	public void allTest() throws Exception {
		sampleRequest = "{\"question\" : \"When will Covid Pandemic end\""+ ",\r\n" + 
				"  \"answer\" : \"2022\"\r\n" + "}";
		
		mvc.perform(post("/FAQ").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andExpect(jsonPath("$.answer").value("2022")) .andReturn();
		
		String sampleRequest2 =  "{\"question\" : \"Will I die or stay alive before 2022\""+ ",\r\n" + 
				"  \"answer\" : \"You will stay alive\"\r\n" + "}";
		
		mvc.perform(post("/FAQ").contentType(MediaType.APPLICATION_JSON).content(sampleRequest2)).andExpect(
				status().isOk()).andExpect(jsonPath("$.answer").value("You will stay alive")) .andReturn();
		
		
		mvc.perform(get("/FAQ/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].answer").value("2022"));
	}
	
	@Test
	public void deleteFAQTest() throws Exception {
		sampleRequest = "{\"question\" : \"When will Covid Pandemic end\""+ ",\r\n" + 
				"  \"answer\" : \"2022\"\r\n" + "}";
		
		MvcResult mvcResult = mvc.perform(post("/FAQ").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andExpect(jsonPath("$.answer").value("2022")) .andReturn();
		
		JSONObject faqResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = faqResponse.getLong("id");		
		
		
		mvc.perform(delete("/FAQ/"+id).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());
		
		try {
			mvc.perform(get("/FAQ/"+ id).contentType(MediaType.APPLICATION_JSON));
		}catch(Exception ex) {
			assertTrue(ex instanceof NestedServletException);
		}
	}

}
