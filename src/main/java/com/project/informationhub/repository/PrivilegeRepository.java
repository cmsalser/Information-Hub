package com.project.informationhub.repository;

import com.project.informationhub.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Perform queries

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>
{
    Optional<Privilege> findById(Long id);

    Privilege findByName(String name);
}