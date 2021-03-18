package com.project.informationhub.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.model.TopicForum;
import com.project.informationhub.service.TopicForumService;

@RestController
@RequestMapping(value = "/topicforum")
public class TopicForumController {
	
	@Autowired	
	TopicForumService TopicForumService;
	
	@PostMapping("")
	public TopicForum createTopic(@Valid @RequestBody TopicForum topic) {
		
		return TopicForumService.createTopic(topic);
	}
	
	@GetMapping("")
	public List<TopicForum> findAll(){
		return TopicForumService.findAll();
		
	}

}
