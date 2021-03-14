package com.project.informationhub.repository;

import com.project.informationhub.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
    
}
