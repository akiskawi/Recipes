package com.group.project.controllers;

import com.group.project.models.Friendship;
import com.group.project.services.FriendshipServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/friendship")
public class FriendshipController {

    @Autowired
    FriendshipServiceInterface friendshipServiceInterface;


    /*
    Post Form to Send a Friend Request.
     */
    @PostMapping("/")
    public String newRecipe(Model model, @RequestParam Friendship friendship) {
        friendshipServiceInterface.addFriend(friendship);
        return "friendRequestSent";
    }

    /*
    Delete a Friend From an ID
     */
    @DeleteMapping("/deleteFriend/{friendshipID}")
    public String deleteFriend(@PathVariable Integer friendshipID) {
        friendshipServiceInterface.deleteFriend(friendshipID);
        return "showAllFriends";
    }

    /*
    Show all of User's Friends
     */
    @GetMapping("/friends/{userId}")
    public String showAllFriends(Model model, @PathVariable Integer userId) {
        model.addAttribute(friendshipServiceInterface.showFriends(userId));
        return "showAllFriends";
    }

}
