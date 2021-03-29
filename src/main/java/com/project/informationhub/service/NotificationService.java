package com.project.informationhub.service;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.Notification;
import com.project.informationhub.model.Post;
import com.project.informationhub.model.PostUpvotes;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.NotificationRepository;
import com.project.informationhub.repository.PostRepository;
import com.project.informationhub.repository.PostUpvotesRepository;
import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.UserRepository;
import com.project.informationhub.utils.Constants;



@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	ThreadRepository threadRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MailService mailservice;
	
	
	public ResponseDto createNotification (Notification notification)
	{
		ResponseDto response = new ResponseDto();
		notification.setTimestampCreated(new Date());
		notification.setTimestampEdited(new Date());
		if("post".equalsIgnoreCase(notification.getType())) {
			
		} 
		Optional<User> optionalUser= userRepository.findById(notification.getAccountId());
		if(optionalUser.isPresent()) {
			String email = optionalUser.get().getEmail();
			mailservice.sendEmail(email, notification.getTitle(), notification.getDescription());
		}
		
		Notification newNotification= notificationRepository.save(notification);
		//send email for notification
		response.setData(newNotification);
		response.setCode(200);
		return response;
	}
	
	public ResponseDto getNotifications (long userId)
	{
		ResponseDto response = new ResponseDto();
		
		List<Notification> notifications= notificationRepository.findByAccountId(userId);
		//send email for notification
		response.setData(notifications);
		response.setCode(200);
		return response;
	}
	
	public ResponseDto get(long notificationId)
	{
		ResponseDto response = new ResponseDto();
		Optional<Notification> isnotification =notificationRepository.findById(notificationId);
		if(isnotification.isPresent()) {
			response.setData(isnotification.get());
			response.setCode(200);
		} else {
			response.setCode(404);
		}
		return response;
	}
	
	public ResponseDto setView(long notificationId,long accountId) {
		ResponseDto response = new ResponseDto();
		Notification notification = notificationRepository.findByIdAndAccountId(notificationId, accountId);
		if(Objects.nonNull(notification)) {
			notification.setViewed(Boolean.TRUE);
			notificationRepository.save(notification);
			response.setCode(200);
			
		} else {
			response.setCode(404);
		}
		return response;
	}
	
	public boolean sendPostNotification(Post post, String subject, String message) {
		boolean isSent = false;
		Optional<com.project.informationhub.model.Thread> optionalThread = Optional.of(post.getThread());
		if(optionalThread.isPresent()) {
			Optional<User> optionalUser= Optional.of(optionalThread.get().getUser());
			if(optionalUser.isPresent()) {
				String email = optionalUser.get().getEmail();
				mailservice.sendEmail(email, subject, message);
				Notification notification = new Notification();
				notification.setTitle(subject);
				notification.setType("POST");
				notification.setDescription(message);
				notification.setAccountId( optionalUser.get().getId());
				notification.setTimestampCreated(new Date());
				notification.setTimestampEdited(new Date());
				notificationRepository.save(notification);
				isSent = true;
			}
		}
		return isSent;
	}
	
	
	
	
	

}
