package com.project.informationhub.integrationTests;

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

import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class NotificationIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	UserRepository userRepository;
	
	User user;
	
	String sampleRequest;
	
	@Test
	public void createNotificationTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
	}
	
	@Test
	public void getAllNotificationByUserTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
		
		mvc.perform(get("/notification/user/"+user.getId()).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].title").value("Java 8 New Features")) .andReturn();
	}
	
	@Test
	public void getNotViewedCountTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
		
		mvc.perform(get("/notification/viewcount/").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].title").value("Java 8 New Features")) .andReturn();
	}
	
	@Test
	public void getNotViewedCountByUser() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
		
		mvc.perform(get("/notification/viewcount/"+user.getId()).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].title").value("Java 8 New Features")) .andReturn();
	}
	
	@Test
	public void getAllNotificationTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
		
		mvc.perform(get("/notification/").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$[0].title").value("Java 8 New Features")) .andReturn();
	}
	
	@Test
	public void getTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		MvcResult mvcResult =  mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
		
		JSONObject notificationResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = notificationResponse.getJSONObject("data").getLong("id");
		
		mvc.perform(get("/notification/"+id).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.code").value(200)).andReturn();
	}
	
	@Test
	public void setViewTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		MvcResult mvcResult =  mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
		
		JSONObject notificationResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = notificationResponse.getJSONObject("data").getLong("id");
		
		mvc.perform(get("/notification/"+id+"/viewed").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());
	}
	
	@Test
	public void deleteNotificationTest() throws Exception{		
		
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edis.emin@hotmail.co.uk");
		user = userRepository.save(user);
		
		
		
		sampleRequest = "{\"accountId\" : "+ user.getId()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\",\r\n" + 
				"  \"priority\" :  1\r\n"  +"}";
		
		MvcResult mvcResult =  mvc.perform(post("/notification").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andExpect(jsonPath("$.code").value(200)) .andReturn();
		
		JSONObject notificationResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		
		Long id = notificationResponse.getJSONObject("data").getLong("id");
		
		mvc.perform(delete("/notification/"+ user.getId()+"/"+id).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());
	}


}
