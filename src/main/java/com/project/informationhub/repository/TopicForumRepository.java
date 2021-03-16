package com.project.informationhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.informationhub.model.TopicForum;

@Repository
public interface TopicForumRepository extends JpaRepository<TopicForum, Integer> {
	
}
