package com.project.informationhub.User;

import javax.persistence.*;

import com.project.informationhub.model.Media;
import com.project.informationhub.model.Thread;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birthday")
    private Date birthday;
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Media> medias= new HashSet<>();
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Thread> threads= new HashSet<>();

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

    public Date getBirthday() {
        return birthday;
    }

    public Long getId() {
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    /**
	 * @return the medias
	 */
	public Set<Media> getMedias() {
		return medias;
	}

	/**
	 * @param medias the medias to set
	 */
	public void setMedias(Set<Media> medias) {
		this.medias = medias;
	}

	/**
	 * @return the threads
	 */
	public Set<Thread> getThreads() {
		return threads;
	}

	/**
	 * @param threads the threads to set
	 */
	public void setThreads(Set<Thread> threads) {
		this.threads = threads;
	}
}
