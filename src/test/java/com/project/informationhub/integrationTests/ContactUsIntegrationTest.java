package com.project.informationhub.integrationTests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
public class ContactUsIntegrationTest {
	
	
	@Autowired
    private MockMvc mvc;
	
	String sampleRequest;
	
	@Test
	public void newContactUsTest() throws Exception {
		sampleRequest = "{\"email\" : \"edis.emin@hotmail.co.uk\""+ ",\r\n" + 
				"  \"phone\" : \"708544274020\",\r\n" + 
				"  \"description\" : \"Please feel free to contact me for any help\"\r\n" + "}";
		
		mvc.perform(post("/contactUs").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.email").value("edis.emin@hotmail.co.uk")) .andReturn();
	}
	
	@Test
	public void oneTest() throws Exception {
		sampleRequest = "{\"email\" : \"edis.emin@hotmail.co.uk\""+ ",\r\n" + 
				"  \"phone\" : \"708544274020\",\r\n" + 
				"  \"description\" : \"Please feel free to contact me for any help\"\r\n" + "}";
		
		MvcResult mvcResult =  mvc.perform(post("/contactUs").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.email").value("edis.emin@hotmail.co.uk")) .andReturn();
		
		JSONObject contactUsResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = contactUsResponse.getLong("id");		
		
		
		mvc.perform(get("/contactUs/"+ id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.email").value("edis.emin@hotmail.co.uk"));
	}
	
	@Test
	public void allTest() throws Exception {
		sampleRequest = "{\"email\" : \"edis.emin@hotmail.co.uk\""+ ",\r\n" + 
				"  \"phone\" : \"708544274020\",\r\n" + 
				"  \"description\" : \"Please feel free to contact me for any help\"\r\n" + "}";
		
		mvc.perform(post("/contactUs").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.email").value("edis.emin@hotmail.co.uk")) .andReturn();
		
		String sampleRequest2 = "{\"email\" : \"edis.emin88@hotmail.com\""+ ",\r\n" + 
				"  \"phone\" : \"077544274020\",\r\n" + 
				"  \"description\" : \"Please feel free to contact me in any emergency\"\r\n" + "}";
		
		mvc.perform(post("/contactUs").contentType(MediaType.APPLICATION_JSON).content(sampleRequest2)).andExpect(
				status().isOk()).andExpect(jsonPath("$.email").value("edis.emin88@hotmail.com")) .andReturn();
		
		
		mvc.perform(get("/contactUs/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].email").value("edis.emin@hotmail.co.uk"));
	}
	
	@Test
	public void deleteContactUsTest() throws Exception {
		sampleRequest = "{\"email\" : \"edis.emin@hotmail.co.uk\""+ ",\r\n" + 
				"  \"phone\" : \"708544274020\",\r\n" + 
				"  \"description\" : \"Please feel free to contact me for any help\"\r\n" + "}";
		
		MvcResult mvcResult = mvc.perform(post("/contactUs").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.email").value("edis.emin@hotmail.co.uk")) .andReturn();
		
		JSONObject contactUsResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = contactUsResponse.getLong("id");	
		
		mvc.perform(delete("/contactUs/"+id).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());
		
		try {
			mvc.perform(get("/contactUs/"+ id).contentType(MediaType.APPLICATION_JSON));
		}catch(Exception ex) {
			assertTrue(ex instanceof NestedServletException);
		}
	}
	
	@Test
	public void putMethodNameTest() throws Exception {
		sampleRequest = "{\"email\" : \"edis.emin@hotmail.co.uk\""+ ",\r\n" + 
				"  \"phone\" : \"708544274020\",\r\n" + 
				"  \"description\" : \"Please feel free to contact me for any help\"\r\n" + "}";
		
		MvcResult mvcResult =  mvc.perform(post("/contactUs").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.email").value("edis.emin@hotmail.co.uk")) .andReturn();
		
		JSONObject contactUsResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = contactUsResponse.getLong("id");
		
		String updateRequest = "{\"email\" : \"edis.emin88@hotmail.com\""+ ",\r\n" + 
				"  \"phone\" : \"708544274020\",\r\n" + 
				"  \"description\" : \"Please feel free to contact me for any help\"\r\n" + "}";
		
		
		mvc.perform(put("/contactUs/"+ id).contentType(MediaType.APPLICATION_JSON).content(updateRequest)).andExpect(status().isOk()).
				andExpect(jsonPath("$.email").value("edis.emin88@hotmail.com"));
	}

}
