package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.User;
import com.group1.FraudDetectionSystem.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
