package com.project.informationhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.entity.MediaType;
import com.project.informationhub.repository.MediaTypeRepository;

@Service
public class MediaTypeService {
	
	@Autowired	
	MediaTypeRepository mediaTypeRepository;
	
	public MediaType createMediaType(MediaType mediaType) {
		
		return mediaTypeRepository.save(mediaType);
	}
	
	public List<MediaType> findAll(){
		return mediaTypeRepository.findAll();
		
	}

}
