package com.project.informationhub.controller;

import java.util.List;

import com.project.informationhub.exception.NotFoundException;

import com.project.informationhub.repository.UserPreferenceRepository;
import com.project.informationhub.model.UserPreference;
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
public class UserPreferenceController {
    
    private final UserPreferenceRepository repository;

    UserPreferenceController(UserPreferenceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<UserPreference> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public UserPreference newFAQ(@RequestBody UserPreference newUserPreference) {
        return repository.save(newUserPreference);
    }

    @GetMapping("/{id}")
    public UserPreference one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping(value="/{id}")
    public UserPreference putMethodName(@PathVariable Long id, @RequestBody UserPreference newUserPreference) {
        return repository.findById(id)
                    .map(UserPreference -> {
                        UserPreference.setEmailNotification(newUserPreference.getEmailNotification());
                        UserPreference.setDarkMode(newUserPreference.getDarkMode());
                    return repository.save(UserPreference);
                    })
                    .orElseGet(() -> {
                        newUserPreference.setId(id);
                        return repository.save(newUserPreference);
                    });
    }

    @DeleteMapping("/{id}")
    public void deleteFAQ(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
