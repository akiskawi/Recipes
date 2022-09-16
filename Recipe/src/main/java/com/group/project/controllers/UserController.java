package com.group.project.controllers;

import com.group.project.models.User;
import com.group.project.services.UserServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andreas
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceInterface userServ;

    @GetMapping("/all")
    public List<User> showAllUsers() {
        return userServ.getAllUsers();
    }

    @GetMapping("/{id}")
    public User showUser(@PathVariable Integer id) {
        return userServ.getUserById(id);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User u) {
        return userServ.createUser(u);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User u) {
        return userServ.updateUser(u);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userServ.deleteUser(id);
    }
}
