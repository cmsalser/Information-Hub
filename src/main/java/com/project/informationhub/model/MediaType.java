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
@Table(name = "mediaType")
public class MediaType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mediatype_id")
	private Long mediaTypeId;
	private String mediaTypeName;
	@OneToMany(mappedBy = "mediaType",cascade = CascadeType.ALL)
	private Set<Media> medias= new HashSet<>();
	
	
	public Set<Media> getMedias() {
		return medias;
	}

	
	public void setMedias(Set<Media> medias) {
		this.medias = medias;
	}

	public MediaType() {
	}
	
	public MediaType(String mediaTypeName) {
		this.mediaTypeName = mediaTypeName;
	}
	
	public Long getMediaTypeId() {
		return mediaTypeId;
	}
	
	public void setMediaTypeId(Long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	
	public String getMediaTypeName() {
		return mediaTypeName;
	}
	
	public void setMediaTypeName(String mediaTypeName) {
		this.mediaTypeName = mediaTypeName;
	}
	
}
