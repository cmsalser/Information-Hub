package com.project.informationhub.controller;

import com.project.informationhub.model.Event;
import com.project.informationhub.repository.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/index")
    public List<Event> index() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Event> show(@PathVariable long id) {
        return eventRepository.findById(id);
    }
}