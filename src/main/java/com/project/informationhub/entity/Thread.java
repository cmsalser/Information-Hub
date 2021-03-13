package com.project.informationhub.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Class for storing information about threads
 *
 */
@Entity
@Table(name = "Thread")
public class Thread {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int threadID;
	private int accountID;
	private String title;
	private String description;
	private String newDesc;
	private boolean anonymous;
	private Date timestampCreated;
	private Date timestampEdited;
	private boolean stickied;
	
	public Thread() {
		
	}
	
	public Thread(int accountID, String title, String description, String newDesc, boolean anonymous,
			boolean stickied) {
		super();
		this.accountID = accountID;
		this.title = title;
		this.description = description;
		this.newDesc = newDesc;
		this.anonymous = anonymous;
		this.stickied = stickied;
		this.timestampCreated = new Date();
		this.timestampEdited = new Date();
	}

	public boolean createThread(int threadID, int accountID, String title, String description) {
		return true;
	}
	
	public boolean createPost(String title, String description) {
		return true;
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
	
	public void updatePost(String newDesc, String description) {
		
	}
	
	public void deletePost(int threadID) {
		
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

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	
	
	

}
