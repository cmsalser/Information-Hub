package com.project.informationhub.entity;

import java.util.Date;
/**
 * 
 * @author Class for storing information about threads
 *
 */
public class Thread {
	
	private int accountID;
	private int threadID;
	private String title;
	private String description;
	private String newDesc;
	private boolean anonymous;
	private Date timestampCreated;
	private Date timestampEdited;
	private boolean stickied;
	
	public boolean createThread(int threadID,int accountID,String title,String description) {
		return true;
	
	}
	
	public boolean createPost(String title,String description) {
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
	
	

}