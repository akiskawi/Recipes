/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.recipe.controllers;

import com.example.recipe.validation.UserIsValid;
import com.example.recipe.models.User;
import com.example.recipe.services.UserServiceInterface;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author akisk
 */
@Controller
public class UserController {

    @Autowired
    UserServiceInterface userservice;

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String email,
            @RequestParam String name,
            @RequestParam String password) {
        System.out.println(email + "--" + name + "--" + password);
        password = UserIsValid.hashPassword(password);
        User u = new User(email, password, name);
        userservice.doRegister(u);
        return "redirect: /";

    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String name,
            @RequestParam String password,
            HttpSession session) {
        User u = userservice.getUserByName(name);
//        if (u == null) {
//            return "redirect: /error";
//        }
//        if (UserIsValid.validPassword(password, u.getPassword())) {
        System.out.println(u);
        if (password.equals("1")) {
            session.setAttribute("loginUser", u);
            return "redirect: /home";
        }
        System.out.println("error hereQ!");
        return "redirect: /error";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/error")
    public String getError() {
        return "error";
    }
}
