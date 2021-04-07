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
public class UserIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	String sampleRequest;
	
	@Test
	public void signUpTest() throws Exception {
		
		sampleRequest = "{\"username\" : \"edis.emin\""+ ",\r\n" + 
				"	\"firstname\" : \"edis\""+ ",\r\n" + 
				"	\"lastname\" : \"emin\""+ ",\r\n" + 
				"	\"password\" : \"Secret@123\""+ ",\r\n" + 
				"	\"email\" : \"edis.emin@hotmail.co.uk\""+ ",\r\n" + 
				"  \"phoneNumber\" : \"708544274020\",\r\n" + 
				"  \"birthday\" : \"1991-04-08\"\r\n" + "}";
		
		mvc.perform(post("/user/signup").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.email").value("edis.emin@hotmail.co.uk")) .andReturn();
		
	}

}
