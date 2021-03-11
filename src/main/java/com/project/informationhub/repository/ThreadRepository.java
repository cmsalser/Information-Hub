package com.informationHub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<com.informationHub.entity.Thread, Integer> {	
	Optional<com.informationHub.entity.Thread> findByAccountID(int accountId);
}
