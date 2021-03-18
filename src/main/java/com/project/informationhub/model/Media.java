package com.project.informationhub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "media")
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "media_id")
	private Long mediaID;
	@Column(name = "media_path")
	private String mediaPath;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mediatype_id", referencedColumnName = "mediatype_id")
	private MediaType mediaType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	private User user;

	public Media() {
		
	}

	public Media(String mediaPath, MediaType mediaType,User user) {
		super();
		this.mediaPath = mediaPath;
		this.mediaType = mediaType;
		this.user = user;
	}

	public Long getMediaID() {
		return mediaID;
	}

	public void setMediaID(Long mediaID) {
		this.mediaID = mediaID;
	}
	
	public String getMediaPath() {
		return mediaPath;
	}
	
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	public MediaType getMediaType() {
		return mediaType;
	}
	
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
