package com.project.informationhub;


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
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;
import com.project.informationhub.service.ThreadService;

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

	@Test
	public void changeAnonymousTest() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		
		ThreadDTO thread = new ThreadDTO();
		thread.setDescription("Thread data");
		thread.setTitle("Title");
		thread.setAccountID(user.getId());
		thread.setAnonymous(true);
		thread.setStickied(false);
		Thread thread4 = threadService.createThread(thread);
		
		assertTrue(thread4.isAnonymous());
		
		thread4 = threadService.changeAnonymous(thread4.getThreadID(),false);
		
		assertFalse(thread4.getStickied());
		
	}

	@Test
	public void searchThreadsByWordTest() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		
		ThreadDTO thread1 = new ThreadDTO();
		thread1.setDescription("Java is getting popular now a days");
		thread1.setTitle("Java 16 launched");
		thread1.setAccountID(user.getId());
		thread1.setAnonymous(true);
		thread1.setStickied(false);
		threadService.createThread(thread1);
		
		ThreadDTO thread2 = new ThreadDTO();
		thread2.setDescription("Covid second wave is very dangerous");
		thread2.setTitle("Covid 2nd wave starts !!");
		thread2.setAccountID(user.getId());
		thread2.setAnonymous(true);
		thread2.setStickied(false);
		threadService.createThread(thread2);
		
		List<com.project.informationhub.model.Thread> searchResults1 =
				threadService.searchThreadsByWord("Java");
		
		assertTrue(searchResults1.size()==1);
		
		List<com.project.informationhub.model.Thread> searchResults2 =
				threadService.searchThreadsByWord("Covid");
		
		assertTrue(searchResults2.size()==1);
			
	}

}
