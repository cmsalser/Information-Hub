package com.project.informationhub.entity;

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
@Table(name = "MEDIA")
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEDIA_ID")
	private Long mediaID;
	@Column(name = "MEDIA_PATH")
	private String mediaPath;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MEDIATYPE_ID", referencedColumnName = "MEDIATYPE_ID")
	private MediaType mediaType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OWNER_ID", referencedColumnName = "ID")
	private User user;

	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(String mediaPath, MediaType mediaType,User user) {
		super();
		this.mediaPath = mediaPath;
		this.mediaType = mediaType;
		this.user = user;
	}

	/**
	 * @return the mediaID
	 */
	public Long getMediaID() {
		return mediaID;
	}

	/**
	 * @param mediaID the mediaID to set
	 */
	public void setMediaID(Long mediaID) {
		this.mediaID = mediaID;
	}

	/**
	 * @return the mediaPath
	 */
	public String getMediaPath() {
		return mediaPath;
	}

	/**
	 * @param mediaPath the mediaPath to set
	 */
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	/**
	 * @return the mediaType
	 */
	public MediaType getMediaType() {
		return mediaType;
	}

	/**
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
