package com.project.informationhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.informationhub.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByTitleContainingOrDescriptionContaining(String word, String word1);
	
	List<Post> findByThreadID(int threadId);

}
