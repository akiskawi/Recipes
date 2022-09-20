package com.group.project.controllers;

import com.group.project.models.Friendship;
import com.group.project.models.User;
import com.group.project.services.FriendshipServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/friendship")
public class FriendshipController {

    @Autowired
    FriendshipServiceInterface friendshipServiceInterface;


    /*
    Post Form to Send a Friend Request.
     */
    @PostMapping("/create")
    void newRecipe(@RequestParam Friendship friendship) {
        friendshipServiceInterface.addFriend(friendship);
    }

    /*
    Delete a Friend From an ID
     */
    @DeleteMapping("/deleteFriend/{friendshipID}")
    void deleteFriend(@PathVariable Integer friendshipID) {
        friendshipServiceInterface.deleteFriend(friendshipID);
    }

    /*
    Show all of User's Friends whose Name contains said string
     */
    @GetMapping("/friends/{userID}/{name}")
    List<User> showAllFriends(@PathVariable Integer userID, @PathVariable String name) {
        return friendshipServiceInterface.showFriends(userID, name);
    }
    /*
    Check's if logged-in User is friend with another user.
     */
    @GetMapping("/friends/{userID}/{friendID}")
    Boolean checkFriendship(@PathVariable Integer userID,@PathVariable Integer friendID){
        return friendshipServiceInterface.checkFriendship(userID, friendID);
    }

}
