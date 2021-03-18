package com.project.informationhub.dto;

public class ThreadDTO {
	
	private Long accountID;
	private String title;
	private String description;
	private boolean anonymous;
	private boolean stickied;
	
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
	
	

}
