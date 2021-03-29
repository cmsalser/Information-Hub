package com.project.informationhub.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * Class maintaining information about a post
 *
 */
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "COMMENT_ID")
	private Long id;

	//@Column(name = "THREAD_ID")
	//@PrimaryKeyJoinColumn
	private int threadID;

	//@Column(name = "TITLE")
	private String title;

	//@Column(name = "DESCRIPTION")
	private String description;

	//@Column(name = "CREATE_DATE")
	private Date timestampCreated;

	//@Column(name = "UPDATE_DATE")
	private Date timestampEdited;

	//@Column(name = "STICKIED")
	private boolean stickied;

	//@JoinColumn(name = "PARENT_POST_ID", nullable = true)
	//@ManyToOne(cascade = CascadeType.ALL)
	//private Post post;

	@JsonManagedReference
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	private Set<PostUpvotes> upvotes= new HashSet<>();
	
	private boolean anonymous;

	public Post() {}

	public Post(int threadID, String title, String description) {
		this.threadID = threadID;
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getThreadID() {
		return threadID;
	}

	public void setThreadID(int threadID) {
		this.threadID = threadID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestampCreated() {
		return timestampCreated;
	}

	public void setTimestampCreated(Date timestampCreated) {
		this.timestampCreated = timestampCreated;
	}

	public Date getTimestampEdited() {
		return timestampEdited;
	}

	public void setTimestampEdited(Date timestampEdited) {
		this.timestampEdited = timestampEdited;
	}

	public boolean isStickied() {
		return stickied;
	}

	public void setStickied(boolean stickied) {
		this.stickied = stickied;
	}
	

//	public Post getPost() {
//		return post;
//	}
//
//	public void setPost(Post post) {
//		this.post = post;
//	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public Set<PostUpvotes> getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(Set<PostUpvotes> upvotes) {
		this.upvotes = upvotes;
	}
}