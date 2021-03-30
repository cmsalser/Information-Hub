package com.project.informationhub.controller;

import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<User> all()
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable long id)
    {
        return repository.findById(id).get();
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user)
    {
        return repository.save(user);
    }

    @GetMapping("/")
    public List<User> index() {
        return repository.findAll();
    }

    @PostMapping("/username")
    public boolean usernameExists(@RequestParam String username) {
        Optional<User> user = repository.findByUsername(username);
        return user.isPresent();
    }

    @PostMapping("/email")
    public boolean emailExists(@RequestParam String email) {
        Optional<User> user = repository.findByEmail(email);
        return user.isPresent();
    }
}