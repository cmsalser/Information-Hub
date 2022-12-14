package com.project.informationhub.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.Notification;
import com.project.informationhub.model.Post;
import com.project.informationhub.service.NotificationService;
import com.project.informationhub.service.PostService;


@RestController
@RequestMapping("notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping
	public ResponseDto createNotification(@RequestBody Notification notification)
	{
		return notificationService.createNotification(notification);
	}
	
	// @GetMapping("/{userId}")
	// public ResponseDto getAllNotificationByUser(@PathVariable long userId)
	// {
	// 	return notificationService.getNotifications(userId);
	// }

	@GetMapping("/user/{userId}")
	public List<Notification> getAllNotificationByUser(@PathVariable long userId)
	{
		return notificationService.getNotificationsList(userId);
	}

	// @GetMapping("")
	// public ResponseDto getAllNotification()
	// {
	// 	return notificationService.getAllNotifications();
	// }

	@GetMapping("/viewcount")
	public List<Notification> getNotViewedCount() {
		return notificationService.getAllNotificationsList();
	}

	@GetMapping("/viewcount/{userId}")
	public List<Notification> getNotViewedCount(@PathVariable long userId) {
		return notificationService.getNotViewedCount(userId);
	}
	
	@GetMapping("")
	public List<Notification> getAllNotification()
	{
		return notificationService.getAllNotificationsList();
	}
	
	@GetMapping("/{notificationId}")
	public ResponseDto get(@PathVariable long notificationId)
	{
		return notificationService.get(notificationId);
	}

	@GetMapping("/{notificationId}/viewed")
	public void setView(@PathVariable long notificationId) {
		notificationService.setViewed(notificationId);
	}
	
	@DeleteMapping("/{userId}/{notificationId}")
	public ResponseDto setViewd(@PathVariable long userId, @PathVariable long notificationId)
	{
		return notificationService.deleteNotification(notificationId, userId);
	}

	

}
