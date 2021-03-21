package com.project.informationhub;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.model.TopicForum;
import com.project.informationhub.service.TopicForumService;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class TopicForumServiceTest {
	
	@Autowired
	TopicForumService topicForumService;
	
	@Test
	public void createTopicTest() {

		TopicForum topicForum = new TopicForum("Covid-19 vaccines");
		TopicForum dbTopicForum = topicForumService.createTopic(topicForum);
		assertEquals("Covid-19 vaccines", dbTopicForum.getTitle());
		assertNotNull(dbTopicForum.getForumID());
		
	}
	
	@Test
	public void findAllTest() {

		TopicForum topicForum1 = new TopicForum("Covid-19 vaccines");
		topicForumService.createTopic(topicForum1);
		TopicForum topicForum2 = new TopicForum("Covid-19 new Variant");
		topicForumService.createTopic(topicForum2);
		List<TopicForum> topicForums = topicForumService.findAll();
		assertTrue(topicForums.size() == 2);
		
	}
	

}
