package com.project.informationhub.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.informationhub.model.Role;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class RoleServiceTest {
	
	@Autowired
	private RoleService roleService;
	
	@Test
	public void createRoleTest() {
		Role adminRole = new Role("admin");
		Role dbRole = roleService.createRole(adminRole);
		
		assertNotNull(dbRole.getId());
		assertEquals("admin", dbRole.getName());
		
		
	}
	
	@Test
	public void getTest() {
		Role adminRole = new Role("admin");
		Role dbRole = roleService.createRole(adminRole);
		
		Optional<Role> role = roleService.get(dbRole.getId());
		
		assertTrue(role.isPresent());
		
	}
	
	@Test
	public void deleteTest() {
		Role adminRole = new Role("admin");
		Role dbRole = roleService.createRole(adminRole);
		
		roleService.delete(dbRole.getId());
		
		Optional<Role> role = roleService.get(dbRole.getId());
		
		assertTrue(role.isEmpty());
		
	}

}
