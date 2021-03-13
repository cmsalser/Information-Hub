package com.project.informationhub.controllers;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.entity.TopicForum;
import com.project.informationhub.repository.TopicForumRepository;

@RestController
@RequestMapping(value = "/topicforum")
public class TopicForumController {
	
	@Autowired	
	TopicForumRepository topicForumRepository;
	
	@PostMapping("")
	public TopicForum createTopic(@Validated @RequestBody TopicForum topic) {
		
		return topicForumRepository.save(topic);
	}
	
	@GetMapping("")
	public List<TopicForum> findAll(){
		return topicForumRepository.findAll();
		
	}

}
