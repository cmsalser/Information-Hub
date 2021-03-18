package com.project.informationhub.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.entity.MediaType;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class MediaTypeServiceTest {
	
	@Autowired
	MediaTypeService mediaTypeService;
	
	@Test
	public void createMediaTypeTest() {
		MediaType mediaType = new MediaType("pdf");
		MediaType dbMediaType = mediaTypeService.createMediaType(mediaType);
		
		assertEquals("pdf", dbMediaType.getMediaTypeName());
		assertNotNull(dbMediaType.getMediaTypeId());		
		
	}
	
	@Test
	public void findAllTest() {
		MediaType mediaType1 = new MediaType("pdf");
		mediaTypeService.createMediaType(mediaType1);
		
		MediaType mediaType2 = new MediaType("mp3");
		mediaTypeService.createMediaType(mediaType2);
		
		List<MediaType> mediaTypes = mediaTypeService.findAll();
		
		assertTrue(mediaTypes.size()==2);
		
		
	}

}
