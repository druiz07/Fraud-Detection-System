package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service for managing users.
 */
@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private long userIdCounter = 1;

    /**
     * Retrieves all users.
     * @return A collection of all users.
     */
    public Collection<User> getAllUsers(){return this.users.values();}

    /**
     * Registers a new user.
     * @param user User details.
     * @return Confirmation message with user ID.
     */
    public String registerUser(User user) {
        user.setId(userIdCounter++);
        users.put(user.getId(), user);
        return "User registered with ID: " + user.getId();
    }
}
