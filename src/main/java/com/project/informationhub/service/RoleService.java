package com.project.informationhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.project.informationhub.model.Role;
import com.project.informationhub.repository.RoleRepository;


@Service
public class RoleService {

    @Autowired
    private RoleRepository usertagrepository;

    // Create UserTag
    public String createRole(Role newrole)
    {
        Role newTag = usertagrepository.save(newrole);

        return newTag.getId();
    }

    // Get Role from ID
    public Optional<Role> get(String roleId)
    {
        return usertagrepository.findById(roleId);
    }

    // Delete UserTag
    public void delete(String roleId)
    {
        Optional<Role>  role_to_delete = get(roleId);
        if(role_to_delete.isPresent())
        {
            usertagrepository.deleteById(roleId);
        }
    }

}