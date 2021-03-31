package com.project.informationhub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.Notification;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;
import com.project.informationhub.service.NotificationService;
import com.project.informationhub.service.UserService;


@SpringBootTest()
@ActiveProfiles("test")
@TestMethodOrder(MethodName.class)
class UserTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void checkLogin() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("12345");
		userRepository.save(user);
		
		ResponseDto response =  userService.getLogin(user);
		assertEquals(200, response.getCode());
		
	}
}
