package com.project.informationhub.controller;

import com.project.informationhub.dto.ResponseDto;
import com.project.informationhub.model.Role;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.UserRepository;
import com.project.informationhub.service.NotificationService;
import com.project.informationhub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository repository;
    
    @Autowired
    UserService userService;
    
    @Autowired
    NotificationService notificationService;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<User> all()
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable long id)
    {
        return repository.findById(id).get();
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user)
    {
    	User registeredUser = repository.save(user);
    	notificationService.sendPNotification(registeredUser, "User Registration", "Welcome to informationhub. Thank you for registring", "REGISTER");
        return registeredUser;
    }
    
    @PostMapping("/signin")
    public ResponseDto signIn(@RequestBody User user)
    {
        return userService.getLogin(user);
    }

    @GetMapping("/")
    public List<User> index() {
        return repository.findAll();
    }

    @PostMapping("/username")
    public boolean usernameExists(@RequestParam String username) {
        Optional<User> user = repository.findByUsername(username);
        return user.isPresent();
    }

    @PostMapping("/email")
    public boolean emailExists(@RequestParam String email) {
        Optional<User> user = repository.findByEmail(email);
        return user.isPresent();
    }

    @GetMapping("/roles/{userID}")
    public Collection<Role> getUserRoles(@PathVariable Long userID)
    {
        User current_user = repository.findById(userID).get();
        Collection<Role> current_roles = current_user.getRoles();
        return current_roles;

        /**
        Collection<Role> roles = userService.getRepository().findAll();
        List<String> strList = new ArrayList<String>();
        Iterator<Role> iterator = roles.iterator();

        // while loop
        while (iterator.hasNext())
        {
            if (iterator.next() == )
        }


        return roleService.get(userID);*/
    }
}