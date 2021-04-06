package com.project.informationhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.informationhub.model.Information;

public interface InformationRepository  extends JpaRepository<Information, Long>{

}
