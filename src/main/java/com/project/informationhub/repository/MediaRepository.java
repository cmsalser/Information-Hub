package com.project.informationhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.informationhub.entity.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long>{
	
	@Query("from Media m inner join fetch m.user where m.user.id = :userId")
	List<Media> findByUserId(@Param("userId") Long userId);

}
