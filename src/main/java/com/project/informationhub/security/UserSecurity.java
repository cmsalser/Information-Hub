package com.project.informationhub.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.project.informationhub.User.CustomUserDetails;

@Component("userSecurity")
public class UserSecurity {
    public boolean hasUserId(Authentication authentication, int userId) {
        CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
        return userId == userDetails.getId();
    }
}