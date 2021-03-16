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
import com.project.informationhub.entity.Notification;
import com.project.informationhub.entity.Post;
import com.project.informationhub.entity.PostUpvotes;
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
	
//	@Autowired
//	UserRole
	
	
	
	public ResponseDto createNotification (Notification notification)
	{
		ResponseDto response = new ResponseDto();
		notification.setTimestampCreated(new Date());
		notification.setTimestampEdited(new Date());
		// set priority based on post upvotes
		if("webinar".equalsIgnoreCase(notification.getType())) {
			//send mail to all user level person
		} else if ("thread".equalsIgnoreCase(notification.getType())) {
			//get user of thread.
			
			//get all staff to send email
		}
		
		Notification newNotification= notificationRepository.save(notification);
		//send email for notification
		response.setData(newNotification);
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
	
	
	
	
	

}
