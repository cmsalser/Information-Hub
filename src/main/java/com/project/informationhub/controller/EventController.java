package com.project.informationhub.controller;

import com.project.informationhub.model.Event;
import com.project.informationhub.model.Role;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.EventRepository;
import com.project.informationhub.repository.RoleRepository;
import com.project.informationhub.repository.UserRepository;
import com.project.informationhub.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private final EventRepository eventRepository;
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;

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
            toUpdate.get().setStartDate(event.getStartDate());
            toUpdate.get().setEndDate(event.getEndDate());
            sendEventUpdateNotification(toUpdate.get());
            return toUpdate.get();
        } else {
            throw new Exception("ID is invalid");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        eventRepository.deleteById(id);
        sendEventDeleteNotification(id);
    }
    
    @PatchMapping("/request/{id}/{userId}/{status}")
    public boolean acceptInvitation(@PathVariable long id, @PathVariable long userId, @PathVariable boolean status) {
    		Optional<Event> isEvent = eventRepository.findById(id); 
        	Optional<User> isuser= userRepository.findById(id);
        	if(!isuser.isPresent()) {
        		return false;
        	}
        	if(isEvent.isPresent() ) {
        		if(status) {
        			notificationService.sendPNotification(isuser.get(), "Event Request accepted", "Event request has been accepted", "EVENT");
        		} else {
        			notificationService.sendPNotification(isuser.get(), "Event Request rejected", "Event request has been rejected", "EVENT");
        		}
        		return true;
        	}
        	return false;
        	
    }
    
    @PostMapping("/request/{id}/{userId}")
    public boolean createEventRequest(@PathVariable long id, @PathVariable long userId) {
    	Optional<Event> isEvent = eventRepository.findById(id); 
    	Optional<User> isuser= userRepository.findById(id);
    	if(!isuser.isPresent()) {
    		return false;
    	}
    	if(isEvent.isPresent()) {
    		Set<User> users = isEvent.get().getAttendees();
    		if(!users.contains(isuser.get())) {
    			users.add(isuser.get());
    			//send notification
    			eventRepository.save(isEvent.get());
    			sendNotificationToAdmin();
    		}
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void sendEventDeleteNotification(long id) {
    	Optional<Event> isEvent = eventRepository.findById(id); 
    	if(isEvent.isPresent()) {
    		Set<User> users = isEvent.get().getAttendees();
    		for (User user : users) {
				notificationService.sendPNotification(user, "Event Cancelled", "Event has been cancelled", "EVENT");
			}
    	}
    }
    
    public void sendNotificationToAdmin() {
		Role role = roleRepository.findByName("ROLE_ADMIN");
		if(Objects.nonNull(role)) {
			List<User> users = userRepository.findByRoles(role);
			for (User user : users) {
				notificationService.sendPNotification(user, "Event request", "New event request has been made", "EVENT");
			}
		}
	}
    
    public void sendEventUpdateNotification(Event event) {
		Set<User> users = event.getAttendees();
		for (User user : users) {
			notificationService.sendPNotification(user, "Event Altered", "Event time/date has been changed", "EVENT");
		}
    	
    }
}