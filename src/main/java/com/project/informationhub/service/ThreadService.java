package com.project.informationhub.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.dto.ThreadDTO;
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.user.User;
import com.project.informationhub.exception.ThreadNotFoundException;
import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.UserRepository;

@Service
public class ThreadService {
	
	@Autowired	
	ThreadRepository threadRepository;
	
	@Autowired
	UserRepository userRepository;
	
    public com.project.informationhub.model.Thread createThread(ThreadDTO newThread) {
		User user = userRepository.findById(newThread.getAccountID()).get();
		com.project.informationhub.model.Thread thread = new com.project.informationhub.model.Thread(user,newThread.getTitle(),
		newThread.getDescription(),newThread.isAnonymous(),newThread.isStickied());    	
        return threadRepository.save(thread);
    }
	
	public com.project.informationhub.model.Thread findById(Long threadId){
		return threadRepository.findById(threadId).orElseThrow(() -> new ThreadNotFoundException(threadId));
		
	}	

	public List<com.project.informationhub.model.Thread> findByAccountId(Long accountId){
		return threadRepository.findByAccountID(accountId);
		
	}
	
	public List<com.project.informationhub.model.Thread> findAll(){
		return threadRepository.findAll();
		
	}
	
    public com.project.informationhub.model.Thread updateThread(Long threadId,ThreadDTO newThread) {
        return threadRepository.findById(threadId)
                    .map(dbThread -> {
                    	dbThread.setTitle(newThread.getTitle());
                    	dbThread.setDescription(newThread.getDescription());
                    	dbThread.setStickied(newThread.isStickied());
                    	dbThread.setAnonymous(newThread.isAnonymous());
                    	dbThread.setTimestampEdited(new Date());
                        return threadRepository.save(dbThread);
                    })
                    .orElseGet(() -> { 
                    	User user = userRepository.findById(newThread.getAccountID()).get();
                    	com.project.informationhub.model.Thread thread = new com.project.informationhub.model.Thread(user,newThread.getTitle(),
                		newThread.getDescription(),newThread.isAnonymous(),newThread.isStickied());  
                        return threadRepository.save(thread);
                    });
    }
	
	
	
    public void deleteThread(Long threadId) {
		threadRepository.deleteById(threadId);
    }

	public Thread setStickied(Long threadId) {
		return threadRepository.findById(threadId)
                .map(dbThread -> {
                	dbThread.setStickied(true);
                	dbThread.setTimestampEdited(new Date());
                    return threadRepository.save(dbThread);
                }).orElseThrow(() -> new ThreadNotFoundException(threadId));
}
	

}
