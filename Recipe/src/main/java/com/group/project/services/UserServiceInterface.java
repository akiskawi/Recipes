package com.group.project.services;

import com.group.project.models.User;
import java.util.List;

/**
 *
 * @author Andreas
 */
public interface UserServiceInterface {
    
    public User createUser(User u);
    
    public List<User> getAllUsers();
    
    public User getUserById(Integer id);
    
    public User updateUser(User u);
    
    public void deleteUser(Integer id);
    
}
