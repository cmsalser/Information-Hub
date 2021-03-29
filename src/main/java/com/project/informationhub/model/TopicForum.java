package com.project.informationhub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class for storing information about a topicForum
 *
 */
@Entity
@Table(name = "topicForum")
public class TopicForum {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "forum_id")
	private Long forumID;
	private String title;	
	@JsonIgnore
	@OneToMany(mappedBy = "topicForum",cascade = CascadeType.ALL)
	private Set<Thread> threads= new HashSet<>();
	
	
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

	public Set<Thread> getThreads() {
		return threads;
	}

	public void setThreads(Set<Thread> threads) {
		this.threads = threads;
	}
	
}
