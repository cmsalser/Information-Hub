package com.project.informationhub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.TopicForum;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.TopicForumRepository;
import com.project.informationhub.repository.UserRepository;
import com.project.informationhub.model.Post;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.dto.PostDTO;
import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.service.PostService;
import com.project.informationhub.service.ThreadService;

@SpringBootTest()
@ActiveProfiles("test")
@TestMethodOrder(MethodName.class)
class InformationhubApplicationTests {
	
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
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("My post");
		postDTO.setTitle("My post title");
		postDTO.setThreadID(thread.getThreadID());
		long postId = postservice.createPost(postDTO);
		System.out.println("post created with > " + postId);
		assertNotEquals(0, postId);
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
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("My post");
		postDTO.setTitle("My post title");
		postDTO.setThreadID(thread.getThreadID());
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
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		Thread thread = new Thread(user, "My Thread", "My description", false, false, forum);
		
		PostDTO postDTO = new PostDTO();
		postDTO.setDescription("My post");
		postDTO.setTitle("My post title");
		postDTO.setThreadID(thread.getThreadID());
		long postId = postservice.createPost(postDTO);
		ResponseDto response1 =postservice.delete(postId);
		System.out.println("delete correct response "+response1);
		assertEquals(200, response1.getCode());
	}
}
