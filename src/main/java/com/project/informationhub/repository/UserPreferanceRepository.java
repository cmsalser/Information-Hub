package com.project.informationhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.informationhub.entity.UserPreferance;

public interface UserPreferanceRepository extends JpaRepository<UserPreferance, Long> {
    
}
