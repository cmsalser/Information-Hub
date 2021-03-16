package com.project.informationhub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.entity.Post;
import com.project.informationhub.service.PostService;

@SpringBootTest()
@ActiveProfiles("test")
@TestMethodOrder(MethodName.class)
class NotificationTests {
	
	@Autowired
	PostService postservice;
	
	Post post;

	@Test
	void createPost() {
		post = new Post();
		post.setId(1l);
		post.setDescription("My post");
		post.setTitle("My post title");
		post.setThreadID(1);
		long postId = postservice.createPost(post);
		System.out.println("post created with > " + postId);
		assertNotEquals(0, postId);
	}
	
	@Test
	void fetchPost() {
		Optional<Post> isPost= postservice.get(10);
		System.out.println("Do we have post with id 1? "+ isPost.isPresent());
		assertEquals(false, isPost.isPresent());
		ResponseDto response = postservice.getPostByThread(1);
		System.out.println("with standard response "+ response);
		assertEquals(200, response.getCode());
	}
	
	
	

}
