package com.milind.usermanagement.controller;

import com.milind.usermanagement.model.User;
import com.milind.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        User user = userService.getUserFromUserId(userId);
        System.out.println("-->" + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List <User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestBody User user) {
        Boolean updated = userService.updateUserInfo(user);
        if(updated) {
            return "User with user id " + user.getUserId() + " updated";
        }
        else {
            return "No such user present";
        }
    }

    @PostMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUserWithUserId(userId);
        return "User Removed";
    }
}
