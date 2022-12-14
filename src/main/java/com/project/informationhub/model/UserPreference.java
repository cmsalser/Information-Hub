package com.project.informationhub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserPreference {
    
    @Id
    @GeneratedValue
    private Long id;

    private boolean emailNotifiation;
    private boolean darkMode;

    public UserPreference() {}

    public UserPreference(boolean emailNotifiation, boolean darkMode) {
        this.emailNotifiation = emailNotifiation;
        this.darkMode = darkMode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getEmailNotification() {
        return emailNotifiation;
    }

    public boolean getDarkMode() {
        return darkMode;
    }

    public void setEmailNotification(boolean emailNotifiation) {
        this.emailNotifiation = emailNotifiation;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Email? : (" + emailNotifiation + ") DarkMode? : (" + darkMode + ")";
    }
}
