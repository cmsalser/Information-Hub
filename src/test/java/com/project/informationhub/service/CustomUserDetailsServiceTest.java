package com.project.informationhub.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class CustomUserDetailsServiceTest {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void loadUserByUsername() {
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user.setUsername("edis.emin");
		user.setPassword("secret123");
		user = userRepository.save(user);
		
		UserDetails userdetails = customUserDetailsService.loadUserByUsername("edis.emin");
		
		assertEquals("edis.emin", userdetails.getUsername());
		assertEquals("secret123", userdetails.getPassword());
		
	}

}
