package com.group.project.repositories;

import com.group.project.models.FriendList;
import com.group.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendListRepoInterface extends JpaRepository<FriendList, Integer> {

    boolean existsByPrimaryUserAndFriendUser(User Primary, User Friend);

    List<FriendList> findByPrimaryUser(User user);
    List<FriendList> findByFriendUser(User user);
}
