package com.project.informationhub.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
/**
 * 
 * Class maintaining information about a post
 *
 */
@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "NOTIFICATION_ID")
	private Long id;
	
	//@Column(name = "ACCOUNT_ID")
	//@PrimaryKeyJoinColumn
	private long accountId;
	
	//@Column(name = "NOTIFICATION_TITLE")
	private String title;
	
	//@Column(name = "DESCRIPTION")
	private String description;
	
	//@Column(name = "PRIORITY")
	private Integer priority;
	
	//@Column(name = "CREATE_DATE")
	private Date timestampCreated;
	
	//@Column(name = "UPDATE_DATE")
	private Date timestampEdited;
	
	//@Column(name = "VIEWED")
	private Boolean viewed;
	
	//@Column(name = "TYPE")
	private String type;
	
	//@Column(name = "TYPE_ID")
	private Long typeId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Boolean  isViewed() {
		return viewed;
	}

	public void setViewed(Boolean  viewed) {
		this.viewed = viewed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	
	
}