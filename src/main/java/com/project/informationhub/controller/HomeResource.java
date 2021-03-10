package com.project.informationhub;

import com.project.informationhub.User.CustomUserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String index() {
        return "<h1>Index</h1>";
    }
}