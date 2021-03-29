package com.project.informationhub.dto;

import java.util.Date;

public class PostDTO {
	
	private Long threadID;

	private String title;

	private String description;

	private Date timestampCreated;

	private Date timestampEdited;

	private boolean stickied;

	public Long getThreadID() {
		return threadID;
	}

	public void setThreadID(Long threadID) {
		this.threadID = threadID;
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

	public boolean isStickied() {
		return stickied;
	}

	public void setStickied(boolean stickied) {
		this.stickied = stickied;
	}
	
	

}
