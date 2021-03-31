package com.project.informationhub.model.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.project.informationhub.model.Thread;
import com.project.informationhub.model.Media;
import com.project.informationhub.model.Role;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 45, unique = true)
    private String username;

    private String firstname;
    private String lastname;
    private String password;

    @Column(length = 45, unique = true)
    private String email;

    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Media> medias= new HashSet<>();
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Thread> threads= new HashSet<>();

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
        // this.birthday = birthday;
    }

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

    // public Date getBirthday() {
    //     return birthday;
    // }

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

    // public void setBirthday(Date birthday) {
    //     this.birthday = birthday;
    // }

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
