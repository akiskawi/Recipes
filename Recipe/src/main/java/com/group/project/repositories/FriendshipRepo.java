package com.group.project.repositories;

import com.group.project.models.Friendship;
import com.group.project.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepo extends JpaRepository<Friendship, Integer> {
    List<Friendship> findByUserId(Integer userID);
    Friendship findByFriendshipId(Integer friendshipID);

    Boolean findByUserIdAndFriendId(Integer userID, Integer friendID);

}
