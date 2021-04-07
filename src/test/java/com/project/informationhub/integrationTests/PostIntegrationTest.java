package com.project.informationhub.integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

import com.project.informationhub.model.Thread;
import com.project.informationhub.model.TopicForum;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.TopicForumRepository;
import com.project.informationhub.repository.UserRepository;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PostIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TopicForumRepository topicForumRepository;
	
	@Autowired
	ThreadRepository threadRepository;
	
	User user;
	Thread thread;
	
	@Test
	public void createPost() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk());
		
		
	}
	
	
	@Test
	public void getTest() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andReturn();
		
		String postID = mvcResult.getResponse().getContentAsString();
		
		
		
		mvc.perform(get("/post/"+ postID).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(postID));
		
		
	}
	
	@Test
	public void getPostByThread() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andReturn();
		
		String postID = mvcResult.getResponse().getContentAsString();
		
		
		
		mvc.perform(get("/post/bythread/"+ thread.getThreadID()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.code").value(200));
		
		
	}

	
	@Test
	public void getPostByAcccount() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andReturn();
		
		String postID = mvcResult.getResponse().getContentAsString();
		
		
		
		mvc.perform(get("/post/byaccount/"+ user.getId()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.code").value(200));
		
		
	}
	
	@Test
	public void getByWord() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Angular 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Angular 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
						status().isOk()).andReturn();
		
		String postID = mvcResult.getResponse().getContentAsString();
		
		
		
		mvc.perform(get("/post/searchByWord/Angular?mostUpvoted=0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].id").value(postID));
		
		
	}
	
	@Test
	public void upvotePost() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andReturn();

		String postID = mvcResult.getResponse().getContentAsString();
		
		User anotherUser = new User();
		anotherUser.setFirstname("Sean");
		anotherUser.setLastname("McGrory");
		anotherUser.setEmail("seanmcgrory@gmail.co.uk");
		anotherUser = userRepository.save(anotherUser);
		
		mvc.perform(put("/post/upvote/"+anotherUser.getId()+"/"+postID).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.code").value(200));
		
	}
	
	@Test
	public void stickiedPost() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andReturn();

		String postID = mvcResult.getResponse().getContentAsString();
		
		mvc.perform(put("/post/stickied/" +postID).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.code").value(200));
		
	}
	
	@Test
	public void stickiedPostWhenPostIsAlreadyStickied() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" +				
				"  \"stickied\" : "+ true + ",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andReturn();

		String postID = mvcResult.getResponse().getContentAsString();
		
		mvc.perform(put("/post/stickied/" +postID).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.code").value(201));
		
	}
	

	@Test
	public void changeAnonymous() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" +				
				"  \"anonymous\" : "+ true + ",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andReturn();

		String postID = mvcResult.getResponse().getContentAsString();
		
		mvc.perform(patch("/post/anonymous/" +postID+"/"+ "false").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(jsonPath("$.code").value(200));
		
	}
	
	@Test
	public void deleteTest() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" +				
				"  \"anonymous\" : "+ true + ",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andReturn();

		String postID = mvcResult.getResponse().getContentAsString();
		
		mvc.perform(delete("/post/"+ postID).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.code").value(200));
		
		mvc.perform(delete("/post/"+ postID).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.code").value(404));
	}
	
	@Test
	public void updateTest() throws Exception {
		user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("edisemin@gmail.co.uk");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		thread = new Thread(user, "OOPs", "Object oriented programming", false, false, forum);
		thread = threadRepository.save(thread);
		String sampleRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 8 New Features\",\r\n" +				
				"  \"anonymous\" : "+ true + ",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 8\"\r\n" +"}";
		
		MvcResult mvcResult = mvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(sampleRequest)).andExpect(
				status().isOk()).andReturn();

		String postID = mvcResult.getResponse().getContentAsString();
		
		String updateRequest = "{\"accountID\" : "+ user.getId()+",\r\n" + 
				"  \"id\" :  "+ postID+",\r\n" + 
				"  \"threadID\" :  "+ thread.getThreadID()+",\r\n" + 
				"  \"title\" : \"Java 11 New Features\",\r\n" +				
				"  \"anonymous\" : "+ true + ",\r\n" + 
				"  \"description\" : \"talks about new features launched in Java 11\"\r\n" +"}";
		
		 mvc.perform(put("/post/").contentType(MediaType.APPLICATION_JSON).content(updateRequest)).andExpect(
					status().isOk());
	}

}
