package com.project.informationhub.User;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    public boolean hasUserId(Authentication authentication, int userId) {
        CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
        return userId == userDetails.getId();
    }
}