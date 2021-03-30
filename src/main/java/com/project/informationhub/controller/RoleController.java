package com.project.informationhub.controller;

import com.project.informationhub.model.Role;
import com.project.informationhub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{roleID}")
    public Optional<Role> get(@PathVariable Long roleID)
    {
        return roleService.get(roleID);
    }
}