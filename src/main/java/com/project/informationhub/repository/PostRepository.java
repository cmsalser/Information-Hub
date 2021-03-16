package com.project.informationhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.informationhub.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findByTitleContainingOrDescriptionContaining(String word, String word1);

}
