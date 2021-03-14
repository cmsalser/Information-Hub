package com.project.informationhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.project.informationhub.model.Role;

import java.util.List;
// Perform queries


public interface RoleRepository extends JpaRepository<Role, Long>
{

    Optional<Role> findById(String id);

    List<Role> findByuser_idIs(String user_id);

    void deleteById(String usertagID);
}
