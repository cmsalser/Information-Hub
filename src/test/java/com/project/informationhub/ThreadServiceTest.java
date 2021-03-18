package com.project.informationhub;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.dto.ThreadDTO;
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.User;
import com.project.informationhub.exception.ThreadNotFoundException;
import com.project.informationhub.repository.UserRepository;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class ThreadServiceTest {

	@Autowired
	ThreadService threadService;

	@Autowired
	UserRepository userRepository;
	

	@Test
	public void createThread() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		Thread thread1 = threadService.createThread(thread);
		System.out.println(thread1.getTitle());
		assertEquals("Title", thread1.getTitle());
	}

	@Test
	public void getThreadTest() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		Thread thread1 = threadService.createThread(thread);
		System.out.println(thread1.getTitle());
		Thread thread2 = threadService.findById(thread1.getThreadID());
		assertEquals("Title", thread2.getTitle());
	}

	@Test
	public void getThreadByAccountID() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		Thread thread1 = threadService.createThread(thread);
		System.out.println(thread1.getUser().getId());
		List<Thread> threads = threadService.findByAccountId(user.getId());
		assertEquals("Title", threads.get(0).getTitle());
	}

	@Test
	public void findByAllTest() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		Thread thread1 = threadService.createThread(thread);
		System.out.println(thread1.getUser().getId());
		List<Thread> threadList = threadService.findAll();
		assertNotEquals(0, threadList.size());
	}

	@Test
	public void deleteThreadTest() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		Thread thread1 = threadService.createThread(thread);
		System.out.println(thread1.getThreadID());
		threadService.deleteThread(thread1.getThreadID());
		try{
			threadService.findById(thread1.getThreadID());
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
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		Thread thread1 = threadService.createThread(thread);
		ThreadDTO thread0 = new ThreadDTO();
		thread0.setDescription("New data");
		thread0.setTitle("Title 2");
		System.out.println(thread1.getThreadID());
		Thread updatedThread = threadService.updateThread(thread1.getThreadID(), thread0);
		assertEquals("Title 2", updatedThread.getTitle());
	}
	
	@Test
	public void setStickiedTest() {
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setStickied(false);
		Thread thread1 = threadService.createThread(thread);
		assertFalse(thread1.getStickied());
		thread1 = threadService.setStickied(thread1.getThreadID());
		assertTrue(thread1.getStickied());
		
	}

}
