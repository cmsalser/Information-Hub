package com.project.informationhub.repository;


import com.project.informationhub.model.Role;
import com.project.informationhub.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    
    List<User> findByRoles(Role role);
}