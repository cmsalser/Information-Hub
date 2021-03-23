package com.project.informationhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.informationhub.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByTitleContainingOrDescriptionContaining(String word, String word1);
	
	@Query("from Post p inner join fetch p.thread where p.thread.threadID = :threadId")
	List<Post> findByThreadID(@Param("threadId")long threadId);
	
	@Query("from Post p inner join fetch p.thread where p.thread.threadID = :threadId and p.thread.stickied=:stickied")
	List<Post> findByThreadIDAndStickied(@Param("threadId")long threadId, @Param("stickied")boolean stickied);
}
