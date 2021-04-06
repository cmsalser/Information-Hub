package com.project.informationhub.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.dto.PostDTO;
import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.Post;
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.TopicForum;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.TopicForumRepository;
import com.project.informationhub.repository.UserRepository;
import com.project.informationhub.utils.Constants;

@SpringBootTest()
@ActiveProfiles("test")
@TestMethodOrder(MethodName.class)
public class PostServiceTest {
	
	@Autowired
	PostService postservice;
	
	@Autowired
	ThreadRepository threadRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TopicForumRepository topicForumRepository;
	
	
	Post post;

	@Test
	void createPost() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("My post");
		postDTO.setTitle("My post title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAnonymous(Boolean.TRUE);
		postDTO.setStickied(Boolean.TRUE);
		postDTO.setAccountID(user.getId());
		long postId = postservice.createPost(postDTO);
		System.out.println("post created with > " + postId);
		assertNotEquals(0, postId);
		assertEquals(Boolean.TRUE, postDTO.isAnonymous());
		assertEquals(Boolean.TRUE, postDTO.isStickied());
	}
	
	@Test
	void fetchPost() {
		Optional<Post> isPost= postservice.get(10);
		System.out.println("Do we have post with id 1? "+ isPost.isPresent());
		assertEquals(false, isPost.isPresent());
		ResponseDto response = postservice.getPostByThread(1l);
		System.out.println("with standard response "+ response);
		assertEquals(200, response.getCode());
	}
	
	@Test
	void upVotePost() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test+2@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("My post");
		postDTO.setTitle("My post title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAccountID(user.getId());
		long postId = postservice.createPost(postDTO);
		ResponseDto response =postservice.upvotePost(postId, 2l);
		
		System.out.println("upvote response "+response);
		assertEquals(200, response.getCode());
		ResponseDto response1 =postservice.upvotePost(postId, 2l);
		
		System.out.println("upvote duplicate "+response1);
		assertEquals(201, response1.getCode());

	}
	
	@Test
	void deletePost() {
		ResponseDto response =postservice.delete(12l);
		System.out.println("delete incorrect response "+response);
		assertEquals(404, response.getCode());
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test+1@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("My post");
		postDTO.setTitle("My post title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAccountID(user.getId());
		long postId = postservice.createPost(postDTO);
		ResponseDto response1 =postservice.delete(postId);
		System.out.println("delete correct response "+response1);
		assertEquals(200, response1.getCode());
	}
	
	@Test
	public void searchPostByWord() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test+5@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("Cars 8");
		postDTO.setTitle("My Cars 8 title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAccountID(user.getId());
		postservice.createPost(postDTO);
		
		PostDTO postDTO1 = new PostDTO();
		postDTO1.setDescription("Cars 11");
		postDTO1.setTitle("My Cars 11 title");
		postDTO1.setAccountID(user.getId());
		postDTO1.setThreadID(thread.getThreadID());
		postDTO1.setAccountID(user.getId());
		postservice.createPost(postDTO1);
		
		 List<Post> searchResult = postservice.searchPostByWord("Cars", 0);
		 assertEquals(2, searchResult.size());
		 
	}
	
	@Test
	public void changeAnonymous() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test+6@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("Java 8");
		postDTO.setTitle("My Java 8 title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAccountID(user.getId());
		postDTO.setAnonymous(true);
		long postId = postservice.createPost(postDTO);
		
		ResponseDto response = postservice.changeAnonymous(postId, false);
		
		assertEquals(200, response.getCode());
		
		
	}
	
	@Test
	public void stickiedPost() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test+7@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("Java 8");
		postDTO.setTitle("My Java 8 title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAccountID(user.getId());
		postDTO.setAnonymous(true);
		long postId = postservice.createPost(postDTO);
		
		ResponseDto response = postservice.stickiedPost(postId);
		
		assertEquals(200, response.getCode());
		assertEquals(Constants.STATUS_SUCCESS, response.getStatus());
		
	}
	
	@Test
	public void getPostByAccount() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test+8@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("Java 8");
		postDTO.setTitle("My Java 8 title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAccountID(user.getId());
		postDTO.setAnonymous(true);
		postservice.createPost(postDTO);
		
		ResponseDto response = postservice.getPostByAccount(user.getId());
		
		assertEquals(200, response.getCode());
		assertEquals(Constants.STATUS_SUCCESS, response.getStatus());
		
	}
	
	@Test
	public void updatePost() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setEmail("test+9@gmail.com");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		thread = threadRepository.save(thread);
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("Java 8");
		postDTO.setTitle("My Java 8 title");
		postDTO.setAccountID(user.getId());
		postDTO.setThreadID(thread.getThreadID());
		postDTO.setAccountID(user.getId());
		postDTO.setAnonymous(true);
		long postId = postservice.createPost(postDTO);
		
		Post post = postservice.get(postId).get();
		PostDTO postDto2 = new PostDTO();
		postDto2.setId(postId);
		postDto2.setTitle("My Java 11 title");
		
		postDto2.setDescription("Java 11");
		
		long updatedPostId = postservice.updatePost(postDto2);
		
		assertEquals(postId, updatedPostId);		
		
		
		
	}
}
