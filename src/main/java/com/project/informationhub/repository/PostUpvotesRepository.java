package com.project.informationhub.repository;

import com.project.informationhub.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.informationhub.model.PostUpvotes;

public interface PostUpvotesRepository extends JpaRepository<PostUpvotes, Long>{
	PostUpvotes findByUserIdAndPost(long userId, Post post);
}
