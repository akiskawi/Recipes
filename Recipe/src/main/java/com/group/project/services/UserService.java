package com.group.project.services;

import com.group.project.models.User;
import com.group.project.repositories.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andreas
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public User createUser(User u) {
        return userRepo.save(u);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User updateUser(User u) {
        User t = userRepo.findById(u.getId()).orElse(null);
        if (t != null) {
            t.setName(u.getName());
            t.setPassword(u.getPassword());
            t.setEmail(u.getEmail());
            t.setRole(u.getRole());
            return userRepo.save(t);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        User t = userRepo.findById(id).orElse(null);
        if (t != null) {
            userRepo.delete(t);
        }
    }

}
