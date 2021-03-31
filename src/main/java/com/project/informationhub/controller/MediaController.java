package com.project.informationhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.dto.MediaDTO;
import com.project.informationhub.service.MediaService;

@RestController
@RequestMapping(value = "/media")
public class MediaController {
	
	@Autowired
	private MediaService mediaService;
	
	@GetMapping("/{mediaId}")
	public MediaDTO findById(@PathVariable(value = "mediaId") Long mediaId){
		return mediaService.findById(mediaId);	
	}
	
	@GetMapping("/user/{userId}")
	public List<MediaDTO> findByUserId(@PathVariable(value = "userId") Long userId){
		return mediaService.findByUserId(userId);	
	}
	
	@PostMapping("")
	public MediaDTO createMedia(@RequestBody MediaDTO mediaDTO) {
		return mediaService.createMedia(mediaDTO);	
	}
	
	@PutMapping(value="/{mediaId}")
    	public MediaDTO updatemedia(@PathVariable Long mediaId, @RequestBody MediaDTO mediaDTO) {
		return mediaService.updateMedia(mediaId, mediaDTO);
    	}
	
	@DeleteMapping("/{mediaId}")
    	public void deleteMedia(@PathVariable Long mediaId) {
		mediaService.deleteMedia(mediaId);
    	}
	
}
