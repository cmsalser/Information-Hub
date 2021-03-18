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

import com.project.informationhub.dto.MediaDTO;
import com.project.informationhub.entity.Media;
import com.project.informationhub.entity.MediaType;
import com.project.informationhub.entity.User;
import com.project.informationhub.exception.MediaNotFoundException;
import com.project.informationhub.repository.MediaTypeRepository;
import com.project.informationhub.repository.UserRepository;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class MediaServiceTest {
	
	@Autowired
	MediaService mediaService;
	
	@Autowired
	MediaTypeRepository mediaTypeRepository;

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void findByIdTest() {
		MediaType mediaType = new MediaType("pdf");
		MediaType dbMediaType = mediaTypeRepository.save(mediaType);
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MediaDTO mediaDTO = new MediaDTO("Covid vaccination.pdf",dbMediaType.getMediaTypeId(),
				user.getId());
		
		MediaDTO dbMedia = mediaService.createMedia(mediaDTO);
		
		MediaDTO mediaFound = mediaService.findById(dbMedia.getMediaId());
		
		assertNotNull(mediaFound);
		assertEquals("Covid vaccination.pdf", mediaFound.getMediaPath());
		
	}
	
	@Test
	public void createMediaTest() {
		MediaType mediaType = new MediaType("pdf");
		MediaType dbMediaType = mediaTypeRepository.save(mediaType);
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MediaDTO mediaDTO = new MediaDTO("Covid vaccination.pdf",dbMediaType.getMediaTypeId(),
				user.getId());
		
		MediaDTO dbMedia = mediaService.createMedia(mediaDTO);
		
		assertNotNull(dbMedia);
		assertEquals("Covid vaccination.pdf", dbMedia.getMediaPath());
	}
	
	@Test
	public void updateMediaTest() {
		MediaType mediaType = new MediaType("pdf");
		MediaType dbMediaType = mediaTypeRepository.save(mediaType);
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MediaDTO mediaDTO = new MediaDTO("Covid vaccination.pdf",dbMediaType.getMediaTypeId(),
				user.getId());
		
		MediaDTO dbMedia = mediaService.createMedia(mediaDTO);
		
		MediaDTO newMediaDTO = new MediaDTO("Covid New Variant.pdf",dbMediaType.getMediaTypeId(),
				user.getId());
		
		MediaDTO updatedMediaDTO = mediaService.updateMedia(dbMedia.getMediaId(), newMediaDTO);
		
		assertNotNull(updatedMediaDTO);
		assertEquals("Covid New Variant.pdf", updatedMediaDTO.getMediaPath());
	}
	
	@Test
	public void deleteMediaTest() {
		MediaType mediaType = new MediaType("pdf");
		MediaType dbMediaType = mediaTypeRepository.save(mediaType);
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MediaDTO mediaDTO = new MediaDTO("Covid vaccination.pdf",dbMediaType.getMediaTypeId(),
				user.getId());
		
		MediaDTO dbMedia = mediaService.createMedia(mediaDTO);
		
		mediaService.deleteMedia(dbMedia.getMediaId());
		
		try {
			mediaService.findById(dbMedia.getMediaId());
		}catch(Exception ex) {
			assertTrue(ex instanceof MediaNotFoundException);
		}
	}
	
	@Test
	public void findByUserIdTest() {
		MediaType mediaType = new MediaType("pdf");
		MediaType dbMediaType = mediaTypeRepository.save(mediaType);
		
		User user = new User();
		user.setFirstname("Edis");
		user.setLastname("Emin");
		user = userRepository.save(user);
		
		MediaDTO mediaDTO1 = new MediaDTO("Covid vaccination.pdf",dbMediaType.getMediaTypeId(),
				user.getId());
		
		MediaDTO mediaDTO2 = new MediaDTO("Covid New variant.pdf",dbMediaType.getMediaTypeId(),
				user.getId());
		
		mediaService.createMedia(mediaDTO1);
		mediaService.createMedia(mediaDTO2);
		
		List<MediaDTO> medias = mediaService.findByUserId(user.getId());
		
		assertTrue(medias.size()==2);
	}

}
