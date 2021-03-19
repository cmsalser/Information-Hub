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
import com.project.informationhub.model.Post;
import com.project.informationhub.service.MailService;
import com.project.informationhub.service.NotificationService;
import com.project.informationhub.service.PostService;

@SpringBootTest()
@ActiveProfiles("test")
@TestMethodOrder(MethodName.class)
class NotificationTests {
	
	@Autowired
	NotificationService notificationService;
	
	
	@Test
	void createNotificationTest() {
		//Mockito.when(mailService.sendEmail(anyString(), anyString(), anyString()));
		Notification notification = new Notification();
		notification.setTitle("Test");
		notification.setDescription("Test");
		notification.setAccountId(1l);
		notification.setTypeId(1l);
		notification.setType("post");
		ResponseDto response = notificationService.createNotification(notification);
		assertEquals(200, response.getCode());
	}

	@Test
	void getAllNotificationTest() {
		Notification notification = new Notification();
		notification.setTitle("Test");
		notification.setDescription("Test");
		notification.setAccountId(1l);
		notification.setTypeId(1l);
		notification.setType("post");
		ResponseDto response = notificationService.createNotification(notification);
		assertEquals(200, response.getCode());
		
		ResponseDto response1 = notificationService.getNotifications(1l);
		System.out.println(response1);
		assertEquals(200, response1.getCode());
	}
	
	@Test
	void getNotification() {
		Notification notification = new Notification();
		notification.setTitle("Test");
		notification.setDescription("Test");
		notification.setAccountId(1l);
		notification.setTypeId(1l);
		notification.setType("post");
		ResponseDto response = notificationService.createNotification(notification);
		assertEquals(200, response.getCode());
		Notification newNotification = (Notification) response.getData();
		
		ResponseDto response1 = notificationService.get(newNotification.getId());
		System.out.println(response1);
		assertEquals(200, response1.getCode());
	}
	
	@Test
	void setNotificationView() {
		Notification notification = new Notification();
		notification.setTitle("Test");
		notification.setDescription("Test");
		notification.setAccountId(1l);
		notification.setTypeId(1l);
		notification.setType("post");
		ResponseDto response = notificationService.createNotification(notification);
		assertEquals(200, response.getCode());
		Notification newNotification = (Notification) response.getData();
		
		ResponseDto response1 = notificationService.setView(newNotification.getId(), 1l);
		System.out.println(response1);
		assertEquals(200, response1.getCode());
	}
	

}
