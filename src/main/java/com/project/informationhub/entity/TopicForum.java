package com.project.informationhub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class for storing information about a topicForum
 *
 */
@Entity
@Table(name = "TopicForum")
public class TopicForum {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int forumID;
	private String title;
		
	public TopicForum() {
		super();
	}

	public TopicForum(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
