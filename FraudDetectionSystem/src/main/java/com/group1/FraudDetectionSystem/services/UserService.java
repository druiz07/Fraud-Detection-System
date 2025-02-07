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

    public Collection<User> getAllUsers(){return this.users.values();}


    public String registerUser(User user) {
        user.setId(userIdCounter++);
        users.put(user.getId(), user);
        return "User registered with ID: " + user.getId();
    }
}
