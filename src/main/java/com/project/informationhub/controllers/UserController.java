package com.project.informationhub.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.informationhub.entity.User;
import com.project.informationhub.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public User show(@PathVariable Integer id) {
        return repository.findById(id).get();
    }
}
