package com.project.informationhub.model;

import com.project.informationhub.model.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "social_worker_id", referencedColumnName = "id")
    private User socialWorker;

    @OneToMany(mappedBy = "event")
    private Set<User> attendees;

    private Date date;

    private String description;

    private String eventLink;
}
