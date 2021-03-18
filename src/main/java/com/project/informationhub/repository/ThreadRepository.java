package com.project.informationhub.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<com.project.informationhub.model.Thread, Long>{
	
	@Query("from Thread t inner join fetch t.user where t.user.id = :accountId")
	List<com.project.informationhub.model.Thread> findByAccountID(@Param("accountId") Long accountId);

}
