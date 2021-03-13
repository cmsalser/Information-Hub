package com.project.informationhub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<com.project.informationhub.entity.Thread, Integer> {	
	Optional<com.project.informationhub.entity.Thread> findByAccountID(int accountId);
}
