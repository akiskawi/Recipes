package com.group.project.services;

import com.group.project.models.FriendList;
import com.group.project.models.User;
import com.group.project.repositories.FriendListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendListService {

    @Autowired
    FriendListRepo friendListRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SecurityService securityService;

    public void saveFriend(UserDto userDto1, int id) throws NullPointerException{

        User user = userRepository.getOne(id);
        UserDto userDto2 = modelMapper.map(user,UserDto.class);

        FriendList friend = new FriendList();
        User user1 = userRepository.findUserByEmail(userDto1.getEmail());
        User user2 = userRepository.findUserByEmail(userDto2.getEmail());
        User firstUser = user1;
        User secondUser = user2;
        if(user1.getId() != user2.getId()){
            firstUser = user2;
            secondUser = user1;
        }
        if( !(friendRepository.existsByFirstUserAndSecondUser(firstUser,secondUser)) ){
            friend.setFriendListPK(firstUser.getId());
            friend.setSecondUser(seconduser);
            friendRepository.save(friend);
        }
    }

    public List<User> getFriends(){

        UserDto currentUserDto = securityService.getUser();
        User currentUser = userRepository.findUserByEmail(currentUserDto.getEmail());
        List<Friend> friendsByFirstUser = friendRepository.findByFirstUser(currentUser);
        List<Friend> friendsBySecondUser = friendRepository.findBySecondUser(currentUser);
        List<User> friendUsers = new ArrayList<>();

        /*
            suppose there are 3 users with id 1,2,3.
            if user1 add user2 as friend database record will be first user = user1 second user = user2
            if user3 add user2 as friend database record will be first user = user2 second user = user3
            it is because of lexicographical order
            while calling get friends of user 2 we need to check as a both first user and the second user
         */
        for (Friend friend : friendsByFirstUser) {
            friendUsers.add(userRepository.findUserById(friend.getSecondUser().getId()));
        }
        for (Friend friend : friendsBySecondUser) {
            friendUsers.add(userRepository.findUserById(friend.getFirstUser().getId()));
        }
        return friendUsers;

    }
}
