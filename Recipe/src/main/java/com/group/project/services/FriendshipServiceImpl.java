package com.group.project.services;

import com.group.project.models.Friendship;
import com.group.project.models.User;
import com.group.project.repository.FriendshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipServiceInterface{

    @Autowired
    FriendshipRepo friendshipRepo;
    UserRepo userRepo;

    @Override
    public void addFriend(Friendship friendship) { friendshipRepo.save(friendship); }

    @Override
    public void deleteFriend(Friendship friendship) {
        friendshipRepo.deleteById(friendship.getFriendshipId());
    }

    @Override
    public List<User> showFriends(Integer userID) {
        List<Friendship> friendships = friendshipRepo.findByUserID(userID);
        List<User> friends = null;
        for (Friendship friendship : friendships) {
            if (friendship.getRequestValid()) {
                friends = userRepo.findAllById(friendship.getFriendId());
            }
        }

        return (friends);
    }
}
