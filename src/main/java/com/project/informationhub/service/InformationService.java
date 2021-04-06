package com.project.informationhub.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.Information;
import com.project.informationhub.repository.InformationRepository;

@Service
public class InformationService {
	
	@Value("${storage.location}")
	private String location;
	
	@Autowired
	InformationRepository informationRepository;

	public ResponseDto saveInformation(MultipartFile file, String text) {
	
		ResponseDto response = new ResponseDto();
		try {
			String fileName = "";
			if(Objects.nonNull(file) && file.getBytes().length != 0) {
				byte[] byts = file.getBytes();
				Path path = Paths.get(location + file.getOriginalFilename() );
				Files.write(path, byts);
				fileName = file.getOriginalFilename();
			}
			Information information = new Information();
			information.setFileName(fileName);
			information.setText(text);
			informationRepository.save(information);
			response.setCode(200);
			response.setMessage("Success");
			
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	public ResponseDto getInformation() {
		ResponseDto response = new ResponseDto();
		List<Information> informations =  informationRepository.findAll();
		response.setCode(200);
		response.setData(informations);
		return response;
	}
	
	public ResponseDto deleteInformation(long id) {
		ResponseDto response = new ResponseDto();
		informationRepository.deleteById(id);
		response.setCode(200);
		response.setMessage("Success");
		return response;
	}
	
	public ResponseEntity<ByteArrayResource> getInformationFile(String fileName) {
		try {
			
			byte[] bytes = Files.readAllBytes(Paths.get(location + fileName));
			ByteArrayResource response = new ByteArrayResource(bytes);
			return ResponseEntity.ok().contentLength(bytes.length).header("Content-Type", "application/octet-stream")
					.header("content-disposition", "attachment; filename=\""+fileName+" \"").body(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
