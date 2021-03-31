package com.project.informationhub.controller;

import com.project.informationhub.model.Event;
import com.project.informationhub.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/")
    public List<Event> index() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Event> show(@PathVariable long id) {
        return eventRepository.findById(id);
    }

    @PostMapping("/")
    public Event create(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/{id}")
    public Event update(@RequestBody Event event, @PathVariable long id) throws Exception {
        Optional<Event> toUpdate = eventRepository.findById(id);
        if(toUpdate.isPresent()) {
            toUpdate.get().setAttendees(event.getAttendees());
            toUpdate.get().setCreator(event.getCreator());
            toUpdate.get().setEventLink(event.getEventLink());
            toUpdate.get().setDescription(event.getDescription());
            toUpdate.get().setDate(event.getDate());
            return toUpdate.get();
        } else {
            throw new Exception("ID is invalid");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        eventRepository.deleteById(id);
    }
}