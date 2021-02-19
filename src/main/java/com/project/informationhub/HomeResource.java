package com.project.informationhub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeResource {

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }
}