package com.project.informationhub.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
/**
 * 
 * Class maintaining information about a post
 *
 */
@Entity
public class Post {
	
	@Id
//	@Column(name = "COMMENT_ID")
	private long commentId;
	
//	@Column(name = "THREAD_ID")
	//@PrimaryKeyJoinColumn
	private long threadID;
	
//	@Column(name = "TITLE")
	private String title;
	
//	@Column(name = "DESCRIPTION")
	private String description;
	
//	@Column(name = "CREATE_DATE")
	private Date timestampCreated;
	
//	@Column(name = "UPDATE_DATE")
	private Date timestampEdited;
	
//	@Column(name = "STICKIED")
	boolean stickied;
	
	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public long getThreadID() {
		return threadID;
	}

	public void setThreadID(int threadID) {
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