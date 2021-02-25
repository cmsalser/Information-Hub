package com.project.informationhub.User;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return repository.save(user);
    }
}
