package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private long userIdCounter = 1;

    public String registerUser(User user) {
        user.setId(userIdCounter++);
        users.put(user.getId(), user);
        return "User registered with ID: " + user.getId();
    }
}
