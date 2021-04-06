package com.project.informationhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.service.InformationService;

@RestController
@RequestMapping("/information")
public class InformationController {
	
	@Autowired
	private InformationService informationService;
	
	@PostMapping("")
	public ResponseDto createInformation(@RequestPart("file") MultipartFile file, @RequestPart("text") String text)
	{
		return informationService.saveInformation(file, text);
	}
	
	@GetMapping("")
	public ResponseDto getInformation()
	{
		return informationService.getInformation();
	}
	
	@DeleteMapping("/{id}")
	public ResponseDto deleteInformation(@PathVariable("id") long id)
	{
		return informationService.deleteInformation(id);
	}
	
	@GetMapping("/{path}")
	public ResponseEntity<ByteArrayResource> getInformationFile(@PathVariable("path") String path)
	{
		return informationService.getInformationFile(path);
	}

}
