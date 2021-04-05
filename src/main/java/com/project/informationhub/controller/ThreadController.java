package com.project.informationhub.controller;

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

import com.project.informationhub.dto.ThreadDTO;
import com.project.informationhub.service.ThreadService;

@RestController
@RequestMapping(value = "/thread")
public class ThreadController {
	
	@Autowired	
	ThreadService threadService;
	
	@PostMapping("")
    	public ThreadDTO createThread(@RequestBody ThreadDTO newThread) {
		return threadService.createThread(newThread);
    	}
	
	@GetMapping("/{threadId}")
	public ThreadDTO findById(@PathVariable(value = "threadId") Long threadId){
		return threadService.findById(threadId);
	}
	
	@GetMapping("/account/{accountId}")
	public List<ThreadDTO> findByAccountId(@PathVariable(value = "accountId") Long accountId){
		return threadService.findByAccountId(accountId);	
	}
	
	@GetMapping("/forum/{forumID}")
	public List<ThreadDTO> findByForumID(@PathVariable(value = "forumID") Long forumID){
		return threadService.findByForumID(forumID);	
	}
	
	@GetMapping("")
	public List<ThreadDTO> findAll(){
		return threadService.findAll();	
	}
	
	@PutMapping(value="/{threadId}")
    	public ThreadDTO updateThread(@PathVariable Long threadId, @RequestBody ThreadDTO newThread) {
        	return threadService.updateThread(threadId, newThread);
    	}
	
	@PutMapping(value ="/stickied/{threadId}")
	public ThreadDTO setStickied(@PathVariable Long threadId){
		return threadService.setStickied(threadId);
	}
	
	@PutMapping(value ="/anonymous/{threadId}/{anonymous}")
	public ThreadDTO changeAnonymous(@PathVariable Long threadId,@PathVariable boolean anonymous){
		return threadService.changeAnonymous(threadId,anonymous);
	}	
	
	
	@DeleteMapping("/{threadId}")
    	public void deleteThread(@PathVariable Long threadId) {
		threadService.deleteThread(threadId);
    	}
	
	@GetMapping("/searchByWord/{word}")
	public List<ThreadDTO> getByWord(@PathVariable String word)
	{
		return threadService.searchThreadsByWord(word);
	}
	
}
