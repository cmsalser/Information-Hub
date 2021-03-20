package com.project.informationhub.integrationTests;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MediaIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	UserRepository userRepository;
	
	User user;
	
	String sampleRequest;
	
	@Test
	public void createMediaTest() throws Exception{
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MvcResult mvcResult =  
				mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"pdf\"}")).andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaTypeId = threadResponse.getLong("mediaTypeId");
		
		sampleRequest = "{\"ownerId\" : "+ user.getId()+",\r\n" + 
				"  \"mediaPath\" : \"Covid New Features.pdf\",\r\n" + 
				"  \"mediaTypeId\" : " +mediaTypeId+"\r\n" +"}";
		
		mvc.perform(post("/media").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.mediaPath").value("Covid New Features.pdf")) .andReturn();
	}
	
	@Test
	public void findByIdTest() throws Exception{
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MvcResult mvcResult =  
				mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"pdf\"}")).andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaTypeId = threadResponse.getLong("mediaTypeId");
		
		sampleRequest = "{\"ownerId\" : "+ user.getId()+",\r\n" + 
				"  \"mediaPath\" : \"Covid New Features.pdf\",\r\n" + 
				"  \"mediaTypeId\" : " +mediaTypeId+"\r\n" +"}";
		
		mvcResult = mvc.perform(post("/media").contentType(MediaType.APPLICATION_JSON).
				content(sampleRequest)).andReturn();
		
		threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaId = threadResponse.getLong("mediaId");
		
		mvc.perform(get("/media/"+ mediaId).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ownerName").value("Edis"));
		
	}
	
	@Test
	public void findByUserIdTest() throws Exception{
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MvcResult mvcResult =  
				mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"pdf\"}")).andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaTypeId = threadResponse.getLong("mediaTypeId");
		
		sampleRequest = "{\"ownerId\" : "+ user.getId()+",\r\n" + 
				"  \"mediaPath\" : \"Covid New Features.pdf\",\r\n" + 
				"  \"mediaTypeId\" : " +mediaTypeId+"\r\n" +"}";
		
		mvc.perform(post("/media").contentType(MediaType.APPLICATION_JSON).
				content(sampleRequest));
		
		mvc.perform(get("/media/user/"+ user.getId()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].ownerName").value("Edis"));
		
	}
	
	@Test
	public void updateMediaTest() throws Exception{
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MvcResult mvcResult =  
				mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"pdf\"}")).andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaTypeId = threadResponse.getLong("mediaTypeId");
		
		sampleRequest = "{\"ownerId\" : "+ user.getId()+",\r\n" + 
				"  \"mediaPath\" : \"Covid New Features.pdf\",\r\n" + 
				"  \"mediaTypeId\" : " +mediaTypeId+"\r\n" +"}";
		
		mvcResult = mvc.perform(post("/media").contentType(MediaType.APPLICATION_JSON).
				content(sampleRequest)).andReturn();
		
		threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaId = threadResponse.getLong("mediaId");
		
		String updateRequest = "{\"ownerId\" : "+ user.getId()+",\r\n" + 
				"  \"mediaPath\" : \"Covid New Variants.pdf\",\r\n" + 
				"  \"mediaTypeId\" : " +mediaTypeId+"\r\n" +"}";
		
		mvc.perform(put("/media/"+mediaId).contentType(MediaType.APPLICATION_JSON).
				content(updateRequest)).andExpect(jsonPath("$.mediaPath").value("Covid New Variants.pdf"));
		
				
	}
	
	@Test
	public void deleteMediatest() throws Exception{
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MvcResult mvcResult =  
				mvc.perform(post("/mediatype").contentType(MediaType.APPLICATION_JSON).content(
				"{\"mediaTypeName\": \"pdf\"}")).andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaTypeId = threadResponse.getLong("mediaTypeId");
		
		sampleRequest = "{\"ownerId\" : "+ user.getId()+",\r\n" + 
				"  \"mediaPath\" : \"Covid New Features.pdf\",\r\n" + 
				"  \"mediaTypeId\" : " +mediaTypeId+"\r\n" +"}";
		
		mvcResult =  mvc.perform(post("/media").contentType(MediaType.APPLICATION_JSON).
				content(sampleRequest)).andReturn();
		
		threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long mediaId = threadResponse.getLong("mediaId");
		
		mvc.perform(delete("/media/"+ mediaId).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		try {
			mvc.perform(get("/media/"+ mediaId).contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.mediaPath").value("Covid New Features.pdf"));
		}catch(Exception ex) {
			assertTrue(ex instanceof NestedServletException);
		}
		
	}

}
