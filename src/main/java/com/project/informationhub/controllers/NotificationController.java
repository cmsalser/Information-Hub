package com.project.informationhub.controllers;

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
import com.project.informationhub.entity.Notification;
import com.project.informationhub.entity.Post;
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
	
	
	
	@GetMapping("/{notificationId}")
	public ResponseDto get(@PathVariable long notificationId)
	{
		return notificationService.get(notificationId);
	}
	
	@PatchMapping("/viewed/{userId}/{notificationId}")
	public ResponseDto setViewd(@PathVariable long userId, @PathVariable long notificationId)
	{
		return notificationService.setView(notificationId, userId);
	}

	

}
