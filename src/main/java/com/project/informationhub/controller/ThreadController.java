package com.project.informationhub.controller;

import java.util.Date;
import java.util.List;

import com.project.informationhub.exception.NotFoundException;
import com.project.informationhub.model.Thread;
import com.project.informationhub.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/thread")
public class ThreadController {
	
	@Autowired
	ThreadRepository threadRepository;
	
	@PostMapping("")
    public Thread createThread(@RequestBody Thread newThread) {
		newThread.setTimestampCreated(new Date());
		newThread.setTimestampEdited(new Date());
        return threadRepository.save(newThread);
    }
	
	@GetMapping("/{threadId}")
	public Thread findById(@PathVariable(value = "threadId") long threadId){
		return threadRepository.findByThreadID(threadId).orElseThrow(() -> new NotFoundException(threadId));
		
	}
	
	@GetMapping("/account/{accountId}")
	public Thread findByAccountId(@PathVariable(value = "accountId") long accountId){
		return threadRepository.findByAccountID(accountId).orElseThrow(() -> new NotFoundException(accountId));
		
	}
	
	@GetMapping("")
	public List<Thread> findAll(){
		return threadRepository.findAll();
		
	}
	
	@PutMapping(value="/{threadId}")
    public Thread updateThread(@PathVariable int threadId, @RequestBody Thread newThread) {
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
