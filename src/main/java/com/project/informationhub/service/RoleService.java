package com.project.informationhub.service;

import com.project.informationhub.model.Role;
import com.project.informationhub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



// hi

@Service
public class RoleService {

    @Autowired
    private RoleRepository usertagrepository;

    // Create UserTag
    public Long createRole(Role newrole)
    {
        Role newRole = usertagrepository.save(newrole);

        return newRole.getId();
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