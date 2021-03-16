package com.project.informationhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.model.TopicForum;
import com.project.informationhub.repository.TopicForumRepository;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/topicforum")
public class TopicForumController {
	
	@Autowired
	TopicForumRepository topicForumRepository;
	
	@PostMapping("")
	public TopicForum createTopic(@Valid @RequestBody TopicForum topic) {
		
		return topicForumRepository.save(topic);
	}
	
	@GetMapping("")
	public List<TopicForum> findAll(){
		return topicForumRepository.findAll();
		
	}

}
