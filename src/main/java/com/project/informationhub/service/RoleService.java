package com.project.informationhub.service;

import com.project.informationhub.model.Role;
import com.project.informationhub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository rolerepository;

    // Create UserTag
    public Role createRole(Role newrole)
    {
        Role newRole = rolerepository.save(newrole);
        return newRole;
    }

    // Get Role from ID
    public Optional<Role> get(Long roleId)
    {
        return rolerepository.findById(roleId);
    }


    // Delete UserTag
    public void delete(Long roleId)
    {
        Optional<Role>  role_to_delete = get(roleId);
        if(role_to_delete.isPresent())
        {
            rolerepository.deleteById(roleId);
        }
    }

}