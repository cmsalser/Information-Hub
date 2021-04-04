package com.project.informationhub.service;

import java.util.ArrayList;
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
import com.project.informationhub.model.Role;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.NotificationRepository;
import com.project.informationhub.repository.PostRepository;
import com.project.informationhub.repository.PostUpvotesRepository;
import com.project.informationhub.repository.RoleRepository;
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
	
	@Autowired
	RoleRepository roleRepository;
	
	
	public ResponseDto createNotification (Notification notification)
	{
		ResponseDto response = new ResponseDto();
		notification.setTimestampCreated(new Date());
		notification.setTimestampEdited(new Date());
		
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
	
	// public ResponseDto getNotifications (long userId)
	// {
	// 	ResponseDto response = new ResponseDto();
		
	// 	List<Notification> notifications= notificationRepository.findByAccountId(userId);
	// 	//send email for notification
	// 	response.setData(notifications);
	// 	response.setCode(200);
	// 	return response;
	// }

	public List<Notification> getNotifications (long userId)
	{
		List<Notification> notifications= notificationRepository.findByAccountId(userId);
		return notifications;
	}
	
	// public ResponseDto getAllNotifications ()
	// {
	// 	ResponseDto response = new ResponseDto();
		
	// 	List<Notification> notifications= notificationRepository.findAll();
	// 	response.setData(notifications);
	// 	response.setCode(200);
	// 	return response;
	// }
	
	public List<Notification> getAllNotifications ()
	{
		ResponseDto response = new ResponseDto();
		
		List<Notification> notifications= notificationRepository.findAll();
		response.setData(notifications);
		response.setCode(200);
		return notifications;
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

	public List<Notification> getNotViewedCount(long userId) {
		// int count = 0;
		List<Notification> toReturn = new ArrayList<Notification>();

		List<Notification> notifications= getNotifications(userId);
		for (int i = 0; i < notifications.size(); i++) {
			if (!notifications.get(i).isViewed() || notifications.get(i).isViewed() == null) {
				toReturn.add(notifications.get(i));
			}
		}

		return toReturn;
	}
	
	public ResponseDto deleteNotification(long notificationId,long accountId) {
		ResponseDto response = new ResponseDto();
		Notification notification = notificationRepository.findByIdAndAccountId(notificationId, accountId);
		if(Objects.nonNull(notification)) {
			notificationRepository.delete(notification);
			//notification.setViewed(Boolean.TRUE);
			//notificationRepository.save(notification);
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
	
	
	public boolean sendPNotification(User user, String subject, String message, String type) {
		boolean isSent = false;
		if(Objects.nonNull(user) && Objects.nonNull(user.getEmail())) {
				String email = user.getEmail();
				mailservice.sendEmail(email, subject, message);
				Notification notification = new Notification();
				notification.setTitle(subject);
				notification.setType(type);
				notification.setDescription(message);
				notification.setAccountId( user.getId());
				notification.setTimestampCreated(new Date());
				notification.setTimestampEdited(new Date());
				notificationRepository.save(notification);
				isSent = true;
			
		}
		return isSent;
	}
	
	public void sendNotificationToAdmin(String subject, String message, String type) {
		Role role = roleRepository.findByName("ROLE_ADMIN");
		if(Objects.nonNull(role)) {
			List<User> users = userRepository.findByRoles(role);
			for (User user : users) {
				sendPNotification(user, subject, message, type);
			}
		}
	}

	public void setViewed(long notificationId) {
		Notification noti = notificationRepository.findById(notificationId).get();
		noti.setViewed();
		notificationRepository.save(noti);
	}
	
}
