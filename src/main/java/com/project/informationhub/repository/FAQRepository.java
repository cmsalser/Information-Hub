package com.project.informationhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.informationhub.entity.FAQ;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
    
}
