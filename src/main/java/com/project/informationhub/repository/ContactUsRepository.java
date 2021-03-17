package com.project.informationhub.repository;

import com.project.informationhub.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {
    
}
