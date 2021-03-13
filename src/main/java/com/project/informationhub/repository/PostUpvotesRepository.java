package com.project.informationhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.informationhub.entity.Post;
import com.project.informationhub.entity.PostUpvotes;

public interface PostUpvotesRepository extends JpaRepository<PostUpvotes, Long>{
	
	PostUpvotes findByUserIdAndPost(long userId, Post post);

}
