package com.project.informationhub.integrationTests;
import static org.hamcrest.Matchers.hasSize;
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
public class ThreadIntegrationTest {
	
	@Autowired
        private MockMvc mvc;
	
	@Autowired
	UserRepository userRepository;
	
	User user;
	
	String sampleRequest;
	
	@Test
	public void createThreadTest() throws Exception{
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.title").value("Java 8 New Features")) .andReturn();
		
	}
	
	@Test
	public void findByIdTest() throws Exception{	
	
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long threadId = threadResponse.getLong("threadID");		
		
		
		mvc.perform(get("/thread/"+ threadId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value("Java 8 New Features"));
		
	}
	
	@Test
	public void findByAccountIdTest() throws Exception{
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk());
		
		mvc.perform(get("/thread/account/"+user.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title").value("Java 8 New Features"));
		
	}
	
	@Test
	public void findAllTest() throws Exception{	
	
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		String sampleRequest2 = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 11 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 11\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk());
		
		mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest2)).andExpect(
				status().isOk());

		
		
		mvc.perform(get("/thread/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title").value("Java 8 New Features"))
				.andExpect(jsonPath("$[1].title").value("Java 11 New Features"));
		
	}
	
	@Test
	public void updateThreadTest() throws Exception{
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		MvcResult mvcResult = 
				mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.title").value("Java 8 New Features")) .andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long threadId = threadResponse.getLong("threadID");	
		
		String updatedRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 15 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 15\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		mvc.perform(put("/thread/"+threadId).contentType(MediaType.APPLICATION_JSON).content(updatedRequest)).andExpect(
				status().isOk()).andExpect(jsonPath("$.title").value("Java 15 New Features")) .andReturn();
		
	}
	
	@Test
	public void setStickiedTest() throws Exception{	
	
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : false \r\n" +"}";
		
		MvcResult mvcResult = 
				mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.title").value("Java 8 New Features")) .andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long threadId = threadResponse.getLong("threadID");
		
		mvc.perform(put("/thread/stickied/"+threadId).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.stickied").value(true)) .andReturn();
		
	}
	
	@Test
	public void deleteThreadTest() throws Exception{

		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : false \r\n" +"}";
		
		MvcResult mvcResult = 
				mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.title").value("Java 8 New Features")) .andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long threadId = threadResponse.getLong("threadID");
		
		mvc.perform(delete("/thread/"+threadId).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());
		
		try {
			mvc.perform(get("/thread/"+ threadId).contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.title").value("Java 8 New Features"));
		}catch(Exception ex) {
			assertTrue(ex instanceof NestedServletException);
		}
	
	}

	@Test
	public void changeAnonymousTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : false \r\n" +"}";
		
		MvcResult mvcResult = 
				mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.anonymous").value(true)) .andReturn();
		
		JSONObject threadResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long threadId = threadResponse.getLong("threadID");
		
		mvc.perform(put("/thread/anonymous/"+threadId+"/false").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.anonymous").value(false)) .andReturn();
		
	}

	@Test
	public void getByWordTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : false \r\n" +"}";
		
		mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.anonymous").value(true));
		
		String sampleRequest2 = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 11 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 11\",\r\n" + 
				"  \"anonymous\" :  true,\r\n" + 
				"  \"stickied\" : true \r\n" +"}";
		
		mvc.perform(post("/thread").contentType(MediaType.APPLICATION_JSON).content(sampleRequest2)).andExpect(
				status().isOk()).andExpect(jsonPath("$.anonymous").value(true));

		
		mvc.perform(get("/thread/searchByWord/Java").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$", hasSize(2)));
		
	}


}
