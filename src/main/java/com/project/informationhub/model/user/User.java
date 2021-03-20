package com.project.informationhub.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.informationhub.model.Media;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String firstname;
    private String lastname;
    private String password;

    @Column(unique=true)
    private String email;

    private String phoneNumber;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private Date birthday;

    public User() {

    }

    public User(String username, String firstname, String lastname, String password, String email, String phoneNumber) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
//        this.birthday = birthday;
    }
 
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<com.project.informationhub.model.Thread> threads = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Media> media = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

//    public Date getBirthday() {
//        return birthday;
//    }

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }

    public void setId(long id) {
        this.id = id;
    }

	public Set<com.project.informationhub.model.Thread> getThreads() {
		return threads;
	}

	public void setThreads(Set<com.project.informationhub.model.Thread> threads) {
		this.threads = threads;
	}
    
}
