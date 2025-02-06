package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.models.User;
import com.group1.FraudDetectionSystem.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
