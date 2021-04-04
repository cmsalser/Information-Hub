package com.project.informationhub.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.dto.ThreadDTO;
import com.project.informationhub.exception.ThreadNotFoundException;
import  com.project.informationhub.model.Thread;
import com.project.informationhub.model.TopicForum;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.TopicForumRepository;
import com.project.informationhub.repository.UserRepository;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class ThreadServiceTest {

	@Autowired
	ThreadService threadService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TopicForumRepository topicForumRepository;
	

	@Test
	public void createThread() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
				
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setForumID(forum.getForumID());
		
		ThreadDTO thread2 = threadService.createThread(thread);
		System.out.println(thread2.getTitle());
		assertEquals("Title", thread2.getTitle());
		assertEquals("Object Oriented Programming", thread2.getForumTitle());
	}

	@Test
	public void getThreadTest() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setForumID(forum.getForumID());
		ThreadDTO thread2 = threadService.createThread(thread);
		System.out.println(thread2.getTitle());
		ThreadDTO thread3 = threadService.findById(thread2.getThreadID());
		assertEquals("Title", thread3.getTitle());
	}

	@Test
	public void getThreadByAccountID() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setForumID(forum.getForumID());
		ThreadDTO thread4 = threadService.createThread(thread);
		List<ThreadDTO> threads = threadService.findByAccountId(user.getId());
		assertEquals("Title", threads.get(0).getTitle());
	}

	@Test
	public void findByAllTest() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setForumID(forum.getForumID());
		ThreadDTO thread4 = threadService.createThread(thread);
		List<ThreadDTO> threadList = threadService.findAll();
		assertNotEquals(0, threadList.size());
	}

	@Test
	public void deleteThreadTest() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setForumID(forum.getForumID());
		ThreadDTO thread4 = threadService.createThread(thread);
		System.out.println(thread4.getThreadID());
		threadService.deleteThread(thread4.getThreadID());
		try{
			threadService.findById(thread4.getThreadID());
		}catch(Exception ex) {
			assertTrue(ex instanceof ThreadNotFoundException);
		}
	}

	@Test
	public void updateThreadTest() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setForumID(forum.getForumID());
		ThreadDTO thread4 = threadService.createThread(thread);
		ThreadDTO thread2 = new ThreadDTO();
		thread2.setDescription("New data");
		thread2.setTitle("Title 2");
		thread.setForumID(forum.getForumID());
		System.out.println(thread4.getThreadID());
		ThreadDTO updatedThread = threadService.updateThread(thread4.getThreadID(), thread2);
		assertEquals("Title 2", updatedThread.getTitle());
	}
	
	@Test
	public void setStickiedTest() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setStickied(false);
		thread.setForumID(forum.getForumID());
		ThreadDTO thread4 = threadService.createThread(thread);
		
		assertFalse(thread4.isStickied());
		
		ThreadDTO updatedThread = threadService.setStickied(thread4.getThreadID());
		
		assertTrue(updatedThread.isStickied());	
	}
	
	@Test
	public void changeAnonymousTest() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setAnonymous(true);
		thread.setStickied(false);
		thread.setForumID(forum.getForumID());
		ThreadDTO thread4 = threadService.createThread(thread);
		
		assertTrue(thread4.isAnonymous());
		
		ThreadDTO updatedThread = threadService.changeAnonymous(thread4.getThreadID(),false);
		
		assertFalse(updatedThread.isAnonymous());
	}
	
	@Test
	public void searchThreadsByWordTest() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		TopicForum forum = new TopicForum("Object Oriented Programming");
		forum =  topicForumRepository.save(forum);
		
		ThreadDTO thread1 = new ThreadDTO();
		thread1.setDescription("Java is getting popular now a days");
		thread1.setTitle("Java 16 launched");
		thread1.setAccountID(user.getId());
		thread1.setAnonymous(true);
		thread1.setStickied(false);
		thread1.setForumID(forum.getForumID());
		threadService.createThread(thread1);
		
		ThreadDTO thread2 = new ThreadDTO();
		thread2.setDescription("Covid second wave is very dangerous");
		thread2.setTitle("Covid 2nd wave starts !!");
		thread2.setAccountID(user.getId());
		thread2.setAnonymous(true);
		thread2.setStickied(false);
		thread2.setForumID(forum.getForumID());
		threadService.createThread(thread2);
		
		List<ThreadDTO> searchResults1 =
				threadService.searchThreadsByWord("Java");
		
		assertTrue(searchResults1.size()==1);
		
		List<ThreadDTO> searchResults2 =
				threadService.searchThreadsByWord("Covid");
		
		assertTrue(searchResults2.size()==1);
	}

}
