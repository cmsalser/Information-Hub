package com.project.informationhub.controller;

import java.util.List;

import com.project.informationhub.model.FAQ;
import com.project.informationhub.repository.FAQRepository;
import com.project.informationhub.exception.NotFoundException;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/FAQ")
public class FAQController {

    private final FAQRepository repository;

    FAQController(FAQRepository repository) {
        this.repository = repository;
    }

    // @GetMapping("/FAQ")
    @GetMapping("")
    public List<FAQ> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public FAQ newFAQ(@RequestBody FAQ newFAQ) {
        return repository.save(newFAQ);
    }

    @GetMapping("/{id}")
    public FAQ one(@PathVariable Long id) {
        return repository.findById(id)
                    .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping(value="/{id}")
    public FAQ putMethodName(@PathVariable Long id, @RequestBody FAQ newFAQ) {
        return repository.findById(id)
                    .map(FAQ -> {
                        FAQ.setQuestion(newFAQ.getQuestion());
                        FAQ.setAnswer(newFAQ.getAnswer());
                        return repository.save(FAQ);
                    })
                    .orElseGet(() -> {
                        newFAQ.setId(id);
                        return repository.save(newFAQ);
                    });
    }

    @DeleteMapping("/{id}")
    public void deleteFAQ(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
