package com.project.informationhub.model;

import com.project.informationhub.model.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "event_creator",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> creators;

    @ManyToMany
    @JoinTable(
            name = "event_user",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> attendees;

    private Date date;

    private String description;

    private String eventLink;

    public Event(Set<User> creators, Set<User> attendees, Date date, String description, String eventLink) {
        this.creators = creators;
        this.attendees = attendees;
        this.date = date;
        this.description = description;
        this.eventLink = eventLink;
    }

    public Event() {

    }

    public long getId() {
        return id;
    }

    public Set<User> getCreator() {
        return creators;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreator(Set<User> creator) {
        this.creators = creators;
    }

    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }
}
