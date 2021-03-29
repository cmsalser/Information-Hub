package com.project.informationhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.exception.TopicForumNotFoundException;
import com.project.informationhub.model.TopicForum;
import com.project.informationhub.repository.TopicForumRepository;

@Service
public class TopicForumService {
	
	@Autowired	
	TopicForumRepository topicForumRepository;
	
	public TopicForum createTopic(TopicForum topic) {
		return topicForumRepository.save(topic);
	}
	
	
	
	public List<TopicForum> findAll(){
		return topicForumRepository.findAll();
	}

	public void deleteTopicForum(Long forumID) {
		topicForumRepository.deleteById(forumID);
	}



	public TopicForum findById(Long forumID) {
		return topicForumRepository.findById(forumID).orElseThrow(() -> new TopicForumNotFoundException(forumID));
	}

}
