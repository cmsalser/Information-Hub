package com.project.informationhub;

import java.util.Date;
/**
 * 
 * Class maintaing information about a post
 *
 */
public class Post {
	private int threadID;
	private String commentID;
	private String title;
	private String description;
	private Date timestampCreated;
	private Date timestampEdited;
	private boolean stickied;
	
	public boolean createPost(int threadID, String commentID, String title,String description) {
		///TODO
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
		///TODO
	}
	
	public void deletePost(int threadID) {
		// Delete post for that threadID in database
		///TODO
	}
	
	public boolean getStickied() {
		return stickied;
	}

	
	public void setStickied(boolean stickied) {
		this.stickied = stickied;
	}

}