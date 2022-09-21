package com.group.project.services;

import com.group.project.models.Friendship;
import com.group.project.models.User;
import com.group.project.repositories.FriendshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipServiceInterface{

    @Autowired
    FriendshipRepo friendshipRepo;

    @Autowired
    UserService userService;

    @Override
    public void addFriend(Integer userID, Integer friendID) {
        Friendship f = new Friendship();
        f.setRequestValid(true);
        f.setUserId(userService.getUserById(userID));
        f.setFriendId(userService.getUserById(friendID));
        friendshipRepo.save(f);
    }

    @Override
    public void deleteFriend(Integer friendshipID) {
        friendshipRepo.deleteById(friendshipID);
    }

    @Override
    public List<User> showFriends(Integer userID, String name) {
        List<Friendship> friendships = friendshipRepo.findByUserId(userID);
        List<User> friends = null;
        for (Friendship friendship : friendships)  {
            if (friendship.getRequestValid()) {
                friends.add(userService.getByIdAndByNameContainingIgnoreCase(friendship.getFriendId().getId(), name));
            }
        }

        return (friends);
    }

    @Override
    public Friendship getFriendship(Integer friendshipID) {
        return (friendshipRepo.findByFriendshipId(friendshipID));
    }

    @Override
    public boolean checkFriendship(Integer userID, Integer friendID) {
        return friendshipRepo.findByUserIdAndFriendId(userID,friendID);
    }

}
