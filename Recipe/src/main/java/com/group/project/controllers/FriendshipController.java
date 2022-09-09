package com.group.project.controllers;

import com.group.project.models.Friendship;
import com.group.project.services.FriendshipServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FriendshipController {

    @Autowired
    FriendshipServiceInterface friendshipServiceInterface;


    /*
    Post Form to Send a Friend Request.
     */
    @PostMapping("/sendFriendRequest")
    public String newRecipe(Model model, @RequestParam Friendship friendship) {
        friendshipServiceInterface.addFriend(friendship);
        return "friendRequestSent";
    }

    /*
    Delete a Friend From an ID
     */
    @GetMapping("/deleteFriend/{id}")
    public String deleteFriend(@PathVariable Integer id) {
        return "showAllFriends";
    }

    /*
    Show all of User's Friends
     */
    @GetMapping("/friends/{id}")
    public String showAllFriends(@PathVariable Integer id) {
        return "showAllFriends";
    }

}
