package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.models.User;
import com.group1.FraudDetectionSystem.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Controller for handling user-related operations.
 */
@RestController
@RequestMapping("/users")

/**
 * Constructor to initialize UserService.
 * @param userService The service handling user logic.
 */
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     * @return A collection of all users.
     */
    @GetMapping
    public Collection<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    /**
     * Registers a new user.
     * @param user The user details.
     * @return A confirmation message with user ID.
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
