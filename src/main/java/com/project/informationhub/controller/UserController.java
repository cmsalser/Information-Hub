package com.project.informationhub.controller;

import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public User show(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return repository.save(user);
    }
}
