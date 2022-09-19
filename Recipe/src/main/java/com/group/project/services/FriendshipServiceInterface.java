package com.group.project.services;

import com.group.project.models.Friendship;
import com.group.project.models.User;
import java.util.List;

public interface FriendshipServiceInterface {
    void addFriend(Friendship friendship);
    void deleteFriend(Integer friendshipID);
    List<User> showFriends(Integer userID);
    Friendship getFriendship(Integer friendshipID);
}
