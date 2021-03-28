package com.project.informationhub.dto;

public class MediaDTO {
	
	private String mediaPath;
	private Long mediaTypeId;
	private String mediaTypeName;
	private Long ownerId;
	private String ownerName;
	private Long mediaId;
	
	public MediaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MediaDTO(String mediaPath, Long mediaTypeId, Long ownerId) {
		super();
		this.mediaPath = mediaPath;
		this.mediaTypeId = mediaTypeId;
		this.ownerId = ownerId;
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
	 * @return the mediaTypeId
	 */
	public Long getMediaTypeId() {
		return mediaTypeId;
	}
	/**
	 * @param mediaTypeId the mediaTypeId to set
	 */
	public void setMediaTypeId(Long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	/**
	 * @return the ownerId
	 */
	public Long getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the mediaId
	 */
	public Long getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * @return the mediaTypeName
	 */
	public String getMediaTypeName() {
		return mediaTypeName;
	}

	/**
	 * @param mediaTypeName the mediaTypeName to set
	 */
	public void setMediaTypeName(String mediaTypeName) {
		this.mediaTypeName = mediaTypeName;
	}
	
	
	

}
