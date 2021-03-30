package com.project.informationhub.model;

import com.project.informationhub.model.user.*;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name = "auto";

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;



    public Role() {
        System.out.println("Create");
    } // Never used

    public Role(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Tag Id: " + id + "; Tag Type: " + name + "\n";
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Collection<Privilege> getPrivileges()
    {
        return privileges;
    }

    public Long getId() {
        return id;
    }

    public String getName() {return name;}

    public void setName(String newname) {name = newname;}

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Role))
            return false;
        Role other = (Role)o;
        return (other.name.equals(this.name));
    }
}