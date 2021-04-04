package com.project.informationhub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.dto.ThreadDTO;
import com.project.informationhub.exception.ThreadNotFoundException;
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.TopicForum;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.TopicForumRepository;
import com.project.informationhub.repository.UserRepository;

@Service
public class ThreadService {
	
	@Autowired	
	ThreadRepository threadRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TopicForumRepository topicForumRepository;
	
	@Autowired
	NotificationService notificationService;
	
    public ThreadDTO createThread(ThreadDTO newThread) {
    	User user = userRepository.findById(newThread.getAccountID()).get();
		TopicForum forum = topicForumRepository.findById(newThread.getForumID()).get();
		com.project.informationhub.model.Thread thread = new com.project.informationhub.model.Thread(user,newThread.getTitle(),
				newThread.getDescription(),newThread.isAnonymous(),newThread.isStickied(),forum);    	
		thread = threadRepository.save(thread);
        notificationService.sendNotificationToAdmin("New Thread created", "New thread has been created in the forum", "THREAD");
        return new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
				thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
				thread.getTopicForum().getTitle());
    }
	
    public ThreadDTO findById(Long threadId){
		return threadRepository.findById(threadId).map(thread ->
		new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
				thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
				thread.getTopicForum().getTitle())).orElseThrow(() -> new ThreadNotFoundException(threadId));
	}	

	public List<ThreadDTO> findByAccountId(Long accountId){
		List<ThreadDTO> response = new ArrayList<>();
		
		threadRepository.findByAccountID(accountId).forEach(thread -> {
			response.add(new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
					thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
					thread.getTopicForum().getTitle()));
		});
		return response;
	}
	
	public List<ThreadDTO> findAll(){
		List<ThreadDTO> response = new ArrayList<>();
		threadRepository.findAll().forEach(thread -> {
			response.add(new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
					thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
					thread.getTopicForum().getTitle()));
		});
		return response;
	}
	
    public ThreadDTO updateThread(Long threadId,ThreadDTO newThread) {
        return threadRepository.findById(threadId)
                    .map(thread -> {
                    	thread.setTitle(newThread.getTitle());
                    	thread.setDescription(newThread.getDescription());
                    	thread.setStickied(newThread.isStickied());
                    	thread.setAnonymous(newThread.isAnonymous());
                    	thread.setTimestampEdited(new Date());
                    	thread = threadRepository.save(thread);
                		return new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
                				thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
                				thread.getTopicForum().getTitle());
                    })
                    .orElseGet(() -> { 
                    	User user = userRepository.findById(newThread.getAccountID()).get();
                    	TopicForum forum = topicForumRepository.findById(newThread.getForumID()).get();
                    	com.project.informationhub.model.Thread thread = new com.project.informationhub.model.Thread(user,newThread.getTitle(),
                				newThread.getDescription(),newThread.isAnonymous(),newThread.isStickied(),forum);  
                    	thread = threadRepository.save(thread);
                		return new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
                				thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
                				thread.getTopicForum().getTitle());
                    });
    }
	
	
	
    public void deleteThread(Long threadId) {
		threadRepository.deleteById(threadId);
    }

	public ThreadDTO setStickied(Long threadId) {
		return threadRepository.findById(threadId)
                .map(dbThread -> {
                	dbThread.setStickied(true);
                	dbThread.setTimestampEdited(new Date());
                    Thread thread =  threadRepository.save(dbThread);
                    return new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
        					thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
        					thread.getTopicForum().getTitle());
                }).orElseThrow(() -> new ThreadNotFoundException(threadId));
}
	
	public List<ThreadDTO> searchThreadsByWord(String word){
		List<ThreadDTO> response = new ArrayList<>();
		threadRepository.findByTitleContainingOrDescriptionContaining(word, word).forEach(thread -> {
			response.add(new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
					thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
					thread.getTopicForum().getTitle()));
		});
		return response;
	}

	public ThreadDTO changeAnonymous(Long threadId, boolean anonymous) {
		return threadRepository.findById(threadId)
                .map(dbThread -> {
                	dbThread.setAnonymous(anonymous);
                	dbThread.setTimestampEdited(new Date());
                	Thread thread =  threadRepository.save(dbThread);
                    return new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
        					thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
        					thread.getTopicForum().getTitle());
                }).orElseThrow(() -> new ThreadNotFoundException(threadId));
	}

	public List<ThreadDTO> findByForumID(Long forumID) {
		List<ThreadDTO> response = new ArrayList<>();
		threadRepository.findByForumID(forumID).forEach(thread -> {
			response.add(new ThreadDTO(thread.getUser().getId(), thread.getThreadID(), thread.getTitle(), 
					thread.getDescription(), thread.isAnonymous(), thread.getStickied(),thread.getTopicForum().getForumID(),
					thread.getTopicForum().getTitle()));
		});
		return response;
	}
	
}
