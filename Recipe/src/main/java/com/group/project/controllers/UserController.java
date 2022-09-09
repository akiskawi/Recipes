/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.controllers;

import com.group.project.models.User;
import com.group.project.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Andreas
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceInterface userServ;

    @GetMapping("")
    public String showAllUsers(ModelMap mm) {
        mm.addAttribute("allusers", userServ.getAllUsers());
        return ("userlist");
    }

    @GetMapping("/add")
    public String addUserForm(ModelMap mm) {
        mm.addAttribute("newuser", new User());
        return ("useradd");
    }

    @PostMapping("/doadd")
    public String addUser(@ModelAttribute("newuser") User u) {
        userServ.createUser(u);
        return ("redirect:/users");
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, ModelMap mm) {
        mm.addAttribute("userup", userServ.getUserById(id));
        return ("userupdate");
    }

    @PostMapping("/doupdate")
    public String updateUser(@ModelAttribute("userup") User u) {
        userServ.updateUser(u);
        return ("redirect:/users");
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userServ.deleteUser(id);
        return ("redirect:/users");
    }
}
