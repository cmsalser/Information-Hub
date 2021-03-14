package com.project.informationhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.project.informationhub.model.Role;
import com.project.informationhub.service.RoleService;

@RestController
@RequestMapping(value = "/roles")

// Handle requests
public class RoleController {
    @Autowired

    private RoleService roleService;

    @PostMapping
    public String createRole(@RequestBody Role role)
    {
        String newid = roleService.createRole(role);
        return newid;
    }

    @GetMapping("/{roleID}")
    public Optional<Role> get(@PathVariable String roleID)
    {
        return roleService.get(roleID);
    }
}
