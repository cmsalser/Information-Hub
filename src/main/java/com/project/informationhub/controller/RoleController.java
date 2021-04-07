package com.project.informationhub.controller;

import com.project.informationhub.model.Role;
import com.project.informationhub.repository.RoleRepository;
import com.project.informationhub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// hi

@RestController
@RequestMapping(value = "/roles")

// Handle requests
public class RoleController {
    @Autowired

    private RoleService roleService;

    @PostMapping
    public Role createRole(@RequestBody Role role)
    {
        return roleService.createRole(role);
    }

    public RoleRepository getRepository()
    {
        return roleService.getRepository();
    }

    @GetMapping("/{roleID}")
    public Optional<Role> get(@PathVariable Long roleID)
    {
        return roleService.get(roleID);
    }

}