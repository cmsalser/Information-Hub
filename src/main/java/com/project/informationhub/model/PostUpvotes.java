package com.project.informationhub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostUpvotes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "POST_UPVOTE_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "POST_ID", referencedColumnName = "COMMENT_ID")
	private Post post;
	
	@Column(name = "USER_ID")
	private long userId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
