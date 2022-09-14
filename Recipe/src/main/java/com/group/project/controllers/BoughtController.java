/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.controllers;

import com.group.project.services.BoughtServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mhtso
 */
@Controller
@RequestMapping("/bought")
public class BoughtController {

    @Autowired
    BoughtServiceInterface boughtService;

    @GetMapping("/table")
    public String showLoggedInUserBoughtRecipesTable() {

        return "userboughtrecipes";
    }

    @GetMapping("/success")
    public String showSuccessPurchasePage() {

        return "successpurchase";
    }

}
