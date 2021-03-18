package com.project.informationhub.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.entity.MediaType;
import com.project.informationhub.service.MediaTypeService;

@RestController
@RequestMapping(value = "/mediatype")
public class MediaTypeController {
	
	@Autowired	
	MediaTypeService mediaTypeService;
	
	@PostMapping("")
	public MediaType createMediaType(@Valid @RequestBody MediaType mediaType) {
		
		return mediaTypeService.createMediaType(mediaType);
	}
	
	@GetMapping("")
	public List<MediaType> findAll(){
		return mediaTypeService.findAll();
		
	}

}
