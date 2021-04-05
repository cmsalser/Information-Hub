package com.project.informationhub.dto;

import com.project.informationhub.model.TopicForum;

public class ThreadDTO {
	
	private Long accountID;
	private Long threadID;
	private String title;
	private String description;
	private boolean anonymous;
	private boolean stickied;
	private Long forumID;
	private String forumTitle;
	
	public ThreadDTO() {
	}
	
	public ThreadDTO(Long accountID,Long threadID, String title, String description, boolean anonymous, boolean stickied,
			Long forumID, String forumTitle) {
		super();
		this.accountID = accountID;
		this.threadID = threadID;
		this.title = title;
		this.description = description;
		this.anonymous = anonymous;
		this.stickied = stickied;
		this.forumID = forumID;
		this.forumTitle = forumTitle;
	}

	public Long getAccountID() {
		return accountID;
	}
	
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isAnonymous() {
		return anonymous;
	}
	
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	
	public boolean isStickied() {
		return stickied;
	}
	
	public void setStickied(boolean stickied) {
		this.stickied = stickied;
	}	

	public Long getForumID() {
		return forumID;
	}

	public void setForumID(Long forumID) {
		this.forumID = forumID;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public Long getThreadID() {
		return threadID;
	}

	public void setThreadID(Long threadID) {
		this.threadID = threadID;
	}
	
	

}
