package com.project.informationhub.ContactUs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactUs {

    @Id
    @GeneratedValue
    private Long id;

    // WE SHOULD CONSIDER ADDING USER TAGS AND USER TAG DESCRIPTION HERE.

    private String email;
    private String description;
    private String phone;

    public ContactUs() {}

    public ContactUs(String email, String description, String phone) {
        this.email = email;
        this.description = description;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Email : (" + email + ") Description : (" + description + ")" + " Phone : (" + phone + ")";
    }
}
