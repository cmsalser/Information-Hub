package com.project.informationhub.dto;

public class MediaDTO {
	
	private String mediaPath;
	private Long mediaTypeId;
	private String mediaTypeName;
	private Long ownerId;
	private String ownerName;
	private Long mediaId;
	
	public MediaDTO() {
		
	}
	
	public MediaDTO(String mediaPath, Long mediaTypeId, Long ownerId) {
		super();
		this.mediaPath = mediaPath;
		this.mediaTypeId = mediaTypeId;
		this.ownerId = ownerId;
	}
	
	public String getMediaPath() {
		return mediaPath;
	}
	
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}
	
	public Long getMediaTypeId() {
		return mediaTypeId;
	}
	
	public void setMediaTypeId(Long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	
	public Long getOwnerId() {
		return ownerId;
	}

	
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	
	public String getOwnerName() {
		return ownerName;
	}

	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	
	public Long getMediaId() {
		return mediaId;
	}

	
	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	
	public String getMediaTypeName() {
		return mediaTypeName;
	}

	
	public void setMediaTypeName(String mediaTypeName) {
		this.mediaTypeName = mediaTypeName;
	}
	
}
