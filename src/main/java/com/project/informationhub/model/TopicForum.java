package com.project.informationhub.model;

import javax.persistence.Column;
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
	@Column(name = "forum_id")
	private Long forumID;

	@Column(name = "title")
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

	public Long getForumID() {
		return forumID;
	}

	public void setForumID(Long forumID) {
		this.forumID = forumID;
	}
	
	

}
