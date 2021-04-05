package com.project.informationhub.service;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public ResponseDto getLogin(User user) {
		ResponseDto response = new ResponseDto();
		Optional<User> isUser= userRepository.findByUsername(user.getUsername());
		if(isUser.isPresent()) {
			if(StringUtils.equals(user.getPassword(), isUser.get().getPassword())) {
				response.setData(isUser.get());
				response.setMessage("success");
				response.setCode(200);
			} else {
				response.setMessage("Invalid Credential");
				response.setCode(400);
			}
		} else {
			response.setMessage("Invalid Credential");
			response.setCode(400);
		}
		return response;
	}
}
