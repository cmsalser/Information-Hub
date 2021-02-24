package com.project.informationhub.ContactUs;

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
@RequestMapping("/ContactUs")
public class ContactUsController {
    
    private final ContactUsRepository repository;

    ContactUsController(ContactUsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<ContactUs> all() {
        return repository.findAll();
    }

    @PostMapping("")
    public ContactUs newContactUs(@RequestBody ContactUs newContactUs) {
        return repository.save(newContactUs);
    }

    @GetMapping("/{id}")
    public ContactUs one(@PathVariable Long id) {
        return repository.findById(id)
                    .orElseThrow(() -> new ContactUsNotFoundException(id));
    }

    @PutMapping(value="/{id}")
    public ContactUs putMethodName(@PathVariable Long id, @RequestBody ContactUs newContactUs) {
        return repository.findById(id)
                    .map(ContactUs -> {
                        ContactUs.setEmail(newContactUs.getEmail());
                        ContactUs.setDescription(newContactUs.getDescription());
                        ContactUs.setPhone(newContactUs.getPhone());
                        return repository.save(ContactUs);
                    })
                    .orElseGet(() -> {
                        newContactUs.setId(id);
                        return repository.save(newContactUs);
                    });
    }

    @DeleteMapping("/{id}")
    public void deleteContactUs(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
