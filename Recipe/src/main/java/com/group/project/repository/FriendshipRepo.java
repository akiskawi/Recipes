package com.group.project.repository;

import com.group.project.models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepo extends JpaRepository<Friendship, Integer> {
    List<Friendship> findByUserID(Integer userID);
}
