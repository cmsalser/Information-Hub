package com.project.informationhub.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.exceptions.ThreadNotFoundException;
import com.project.informationhub.repository.ThreadRepository;

@RestController
@RequestMapping(value = "/thread")
public class ThreadController {
	
	@Autowired	
	ThreadRepository threadRepository;
	
	@PostMapping("")
    public com.project.informationhub.entity.Thread createThread(@RequestBody com.project.informationhub.entity.Thread newThread) {
		newThread.setTimestampCreated(new Date());
		newThread.setTimestampEdited(new Date());
        return threadRepository.save(newThread);
    }
	
	@GetMapping("/{threadId}")
	public com.project.informationhub.entity.Thread findById(@PathVariable(value = "threadId") int threadId){
		return threadRepository.findById(threadId).orElseThrow(() -> new ThreadNotFoundException(threadId));
		
	}
	
	@GetMapping("/account/{accountId}")
	public com.project.informationhub.entity.Thread findByAccountId(@PathVariable(value = "accountId") int accountId){
		return threadRepository.findByAccountID(accountId).orElseThrow(() -> new ThreadNotFoundException(accountId));
		
	}
	
	@GetMapping("")
	public List<com.project.informationhub.entity.Thread> findAll(){
		return threadRepository.findAll();
		
	}
	
	@PutMapping(value="/{threadId}")
    public com.project.informationhub.entity.Thread updateThread(@PathVariable int threadId, @RequestBody com.project.informationhub.entity.Thread newThread) {
        return threadRepository.findById(threadId)
                    .map(dbThread -> {
                    	dbThread.setTitle(newThread.getTitle());
                    	dbThread.setDescription(newThread.getDescription());
                    	dbThread.setStickied(newThread.getStickied());
                    	dbThread.setTimestampEdited(new Date());
                        return threadRepository.save(dbThread);
                    })
                    .orElseGet(() -> {                    	
                        return threadRepository.save(newThread);
                    });
    }
	
	@DeleteMapping("/{threadId}")
    public void deleteThread(@PathVariable int threadId) {
		threadRepository.deleteById(threadId);
    }
	

}
