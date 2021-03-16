package com.project.informationhub.repository;

import java.util.Optional;

import com.project.informationhub.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepository extends JpaRepository<Thread, Integer> {
	Optional<Thread> findByAccountID(long accountId);
	Optional<Thread> findByThreadID(long threadId);
}
