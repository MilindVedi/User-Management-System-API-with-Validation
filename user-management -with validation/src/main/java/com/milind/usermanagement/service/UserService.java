package com.milind.usermanagement.service;

import com.milind.usermanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserService {
    private static HashMap<Integer, User> userIdsToUsers = new HashMap<>();
    public String addUser(User user) {
        userIdsToUsers.put(user.getUserId(), user);
        return "User " + user.getUsername() + " Saved";
    }

    public User getUserFromUserId(int userid) {
        System.out.println(userIdsToUsers);
        return userIdsToUsers.get(userid);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>(userIdsToUsers.values());
        return users;
    }

    public boolean updateUserInfo(User user) {
        if(userIdsToUsers.containsKey(user.getUserId())) {
            userIdsToUsers.put(user.getUserId(), user);
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteUserWithUserId(int userId) {
        userIdsToUsers.remove(userId);
    }
}
