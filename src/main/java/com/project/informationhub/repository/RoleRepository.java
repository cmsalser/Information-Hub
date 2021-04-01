package com.project.informationhub.repository;

import com.project.informationhub.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Perform queries

public interface RoleRepository extends JpaRepository<Role, Long>
{
    Optional<Role> findById(Long id);

    Role findByName(String role_admin);
}