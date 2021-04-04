package com.project.informationhub.repository;

import java.util.List;

import com.project.informationhub.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByTitleContainingOrDescriptionContaining(String word, String word1);
	
	@Query("from Post p inner join fetch p.user where p.user.id = :accountId")
	List<Post> findByAccountID(@Param("accountId") Long accountId);
	
	@Query("from Post p inner join fetch p.thread where p.thread.threadID = :threadId")
	List<Post> findByThreadID(@Param("threadId") Long threadId);
	
	@Query("from Post p inner join fetch p.thread where p.thread.threadID = :threadId and stickied =  :sticked")
	List<Post> findByThreadIDAndStickied(@Param("threadId")Long threadId, @Param("sticked") boolean sticked);
}
