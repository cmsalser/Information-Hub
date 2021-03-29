package com.project.informationhub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.model.user.User;
import com.project.informationhub.dto.MediaDTO;
import com.project.informationhub.exception.MediaNotFoundException;
import com.project.informationhub.model.Media;
import com.project.informationhub.model.MediaType;
import com.project.informationhub.repository.MediaRepository;
import com.project.informationhub.repository.MediaTypeRepository;
import com.project.informationhub.repository.UserRepository;

@Service
public class MediaService {
	
	@Autowired	
	MediaRepository mediaRepository;
	
	@Autowired
	MediaTypeRepository mediaTypeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public MediaDTO findById(Long mediaId) {
		return mediaRepository.findById(mediaId).map(
				dbMedia -> {
					MediaDTO mediaDTO = new MediaDTO(dbMedia.getMediaPath(),dbMedia.getMediaType().getMediaTypeId(),
							dbMedia.getUser().getId());
					mediaDTO.setMediaTypeName(dbMedia.getMediaType().getMediaTypeName());
					mediaDTO.setOwnerName(dbMedia.getUser().getFirstname());
					mediaDTO.setMediaId(dbMedia.getMediaID());
					return mediaDTO;
					
				}
				).orElseThrow(() -> new MediaNotFoundException(mediaId));
	}
	
	public MediaDTO createMedia(MediaDTO mediaDTO) {
		MediaType mediaType= mediaTypeRepository.findById(mediaDTO.getMediaTypeId()).get();
		User user = userRepository.findById(mediaDTO.getOwnerId()).get();
		Media media = new Media(mediaDTO.getMediaPath(),mediaType,user);
		media =  mediaRepository.save(media);
		mediaDTO.setMediaId(media.getMediaID());
		mediaDTO.setMediaTypeName(media.getMediaType().getMediaTypeName());
		mediaDTO.setOwnerName(media.getUser().getFirstname());
		return mediaDTO;
	}
	
	public MediaDTO updateMedia(Long mediaId, MediaDTO mediaDTO) {
		MediaType mediaType= mediaTypeRepository.findById(mediaDTO.getMediaTypeId()).get();
		User user = userRepository.findById(mediaDTO.getOwnerId()).get();
		return mediaRepository.findById(mediaId)
                    .map(dbMedia -> {
                    	dbMedia.setMediaPath(mediaDTO.getMediaPath());
                    	dbMedia.setMediaType(mediaType);
                    	dbMedia.setUser(user);
                    	dbMedia =  mediaRepository.save(dbMedia);
                		mediaDTO.setMediaId(dbMedia.getMediaID());
                		mediaDTO.setMediaTypeName(dbMedia.getMediaType().getMediaTypeName());
                		mediaDTO.setOwnerName(dbMedia.getUser().getFirstname());
                		return mediaDTO;
                    })
                    .orElseGet(() -> {                    	
                    	Media media = mediaRepository.save(new Media(mediaDTO.getMediaPath(),mediaType,user));
                    	mediaDTO.setMediaId(media.getMediaID());
                		mediaDTO.setMediaTypeName(media.getMediaType().getMediaTypeName());
                		mediaDTO.setOwnerName(media.getUser().getFirstname());
                		return mediaDTO;
                    });
	}
	
	public void deleteMedia(Long mediaId) {
		mediaRepository.deleteById(mediaId);
	}

	public List<MediaDTO> findByUserId(Long userId) {
		List<MediaDTO> mediaDTOs = new ArrayList<>();
		
		mediaRepository.findByUserId(userId).forEach(dbMedia ->{
			MediaDTO mediaDTO = new MediaDTO(dbMedia.getMediaPath(),dbMedia.getMediaType().getMediaTypeId(),
					dbMedia.getUser().getId());
			mediaDTO.setMediaTypeName(dbMedia.getMediaType().getMediaTypeName());
			mediaDTO.setOwnerName(dbMedia.getUser().getFirstname());
			mediaDTO.setMediaId(dbMedia.getMediaID());
			mediaDTOs.add(mediaDTO);
			
		});
		
		return mediaDTOs;
	}
	
}
