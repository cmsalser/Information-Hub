package com.project.informationhub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userPreferance")
public class UserPreferanceController {
    
    private final UserPreferanceRepository repository;

    UserPreferanceController(UserPreferanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<UserPreferance> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public UserPreferance newFAQ(@RequestBody UserPreferance newuUserPreferance) {
        return repository.save(newuUserPreferance);
    }

    @GetMapping("/{id}")
    public UserPreferance one(@PathVariable Long id) {
        return repository.findById(id).get();
                    // .orElseThrow(() -> new UserPreferanceNotFoundException(id));
    }

    @PutMapping(value="/{id}")
    public UserPreferance putMethodName(@PathVariable Long id, @RequestBody UserPreferance newUserPreferance) {
        return repository.findById(id)
                    .map(UserPreferance -> {
                        UserPreferance.setEmailNotification(newUserPreferance.getEmailNotification());
                        UserPreferance.setDarkMode(newUserPreferance.getDarkMode());
                    return repository.save(UserPreferance);
                    })
                    .orElseGet(() -> {
                        newUserPreferance.setId(id);
                        return repository.save(newUserPreferance);
                    });
    }

    @DeleteMapping("/{id}")
    public void deleteFAQ(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
