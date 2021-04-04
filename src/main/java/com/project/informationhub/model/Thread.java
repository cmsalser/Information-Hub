package com.project.informationhub.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.informationhub.model.user.User;
/**
 * 
 * @author Class for storing information about threads
 *
 */
@Entity
@Table(name = "thread")
public class Thread implements Serializable{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "thread_id")
	private Long threadID;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private User user;
	private String title;
	private String description;
	private boolean anonymous;
	@Column(name = "create_date")
	private Date timestampCreated;
	@Column(name = "update_date")
	private Date timestampEdited;
	private boolean stickied;
	@JsonIgnore
	@OneToMany(mappedBy = "thread",cascade = CascadeType.ALL)
	private Set<Post> posts= new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "forum_id", referencedColumnName = "forum_id")
	private TopicForum topicForum;
	
	public Thread() {
		
	}
	
	
	public Thread(User user, String title, String description, boolean anonymous,
			boolean stickied,TopicForum topicForum) {
		super();
		this.user = user;
		this.title = title;
		this.description = description;
		this.anonymous = anonymous;
		this.stickied = stickied;
		this.timestampCreated = new Date();
		this.timestampEdited = new Date();
		this.topicForum = topicForum;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getStickied() {
		return stickied;
	}

	public void setStickied(boolean stickied) {
		this.stickied = stickied;
	}

	public Date getTimestampCreated() {
		return timestampCreated;
	}

	public void setTimestampCreated(Date timestampCreated) {
		this.timestampCreated = timestampCreated;
	}

	public Date getTimestampEdited() {
		return timestampEdited;
	}

	public void setTimestampEdited(Date timestampEdited) {
		this.timestampEdited = timestampEdited;
	}

	public Set<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public Long getThreadID() {
		return threadID;
	}

	public void setThreadID(Long threadID) {
		this.threadID = threadID;
	}

	public TopicForum getTopicForum() {
		return topicForum;
	}

	public void setTopicForum(TopicForum topicForum) {
		this.topicForum = topicForum;
	}	
	
}
