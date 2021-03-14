package com.project.informationhub.model;
import javax.persistence.*;

import com.project.informationhub.model.user.User;

import java.util.Collection;

@Entity
@Table(name = "role")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String user_id;
    private String name;

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

    public Role() {} // Never used

    public Role(String my_tag_id, String my_user_id, String name)
    {
        // It doesn't make sense to give any of these methods getters
        this.id = my_tag_id;
        this.user_id = my_user_id;
        this.name = name;
    }


    @Override
    public String toString()
    {
        return "Tag Id: " + id + "; User ID: " + user_id + "; Tag Type: " + name + "\n";
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Collection<Privilege> getPrivileges()
    {
        return privileges;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Role))
            return false;
        Role other = (Role)o;
        return (other.user_id.equals(this.user_id) && other.name.equals(this.name));
    }
}
