package com.group.project.services;

import com.group.project.models.Friendship;
import com.group.project.models.User;
import java.util.List;

public interface FriendshipServiceInterface {
    void addFriend(Friendship friendship);
    void deleteFriend(Integer friendshipID);
    public List<User> showFriends(Integer userID, String name);
    Friendship getFriendship(Integer friendshipID);

    boolean checkFriendship(Integer userID, Integer friendID);
}
