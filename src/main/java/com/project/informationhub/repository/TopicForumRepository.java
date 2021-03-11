package com.informationHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informationHub.entity.TopicForum;


@Repository
public interface TopicForumRepository extends JpaRepository<TopicForum, Integer> {
	
}
