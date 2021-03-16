package com.project.informationhub.repository;

import java.util.List;

import com.project.informationhub.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByTitleContainingOrDescriptionContaining(String word, String word1);
	
	List<Post> findByThreadID(int threadId);
	
	List<Post> findByThreadIDAndStickied(int threadId, boolean sticked);
}
