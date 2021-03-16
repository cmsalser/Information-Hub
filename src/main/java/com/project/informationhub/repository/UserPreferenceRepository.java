package com.project.informationhub.repository;

import com.project.informationhub.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    
}
