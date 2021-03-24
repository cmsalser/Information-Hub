package com.project.informationhub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MEDIA_TYPE")
public class MediaType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEDIATYPE_ID")
	private Long mediaTypeId;
	@Column(name = "MEDIATYPE_NAME")
	private String mediaTypeName;
	@OneToMany(mappedBy = "mediaType",cascade = CascadeType.ALL)
	private Set<Media> medias= new HashSet<>();
	
	/**
	 * @return the medias
	 */
	public Set<Media> getMedias() {
		return medias;
	}

	/**
	 * @param medias the medias to set
	 */
	public void setMedias(Set<Media> medias) {
		this.medias = medias;
	}

	public MediaType() {
	}
	
	public MediaType(String mediaTypeName) {
		this.mediaTypeName = mediaTypeName;
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
