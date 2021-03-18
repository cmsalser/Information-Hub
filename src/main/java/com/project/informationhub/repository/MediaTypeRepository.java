package com.project.informationhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.informationhub.entity.MediaType;

@Repository
public interface MediaTypeRepository extends JpaRepository<MediaType, Long>{

}
