package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {
    private final Map<Long, Account> accounts = new HashMap<>();
    private long accountIdCounter = 1;

    public String createAccount(Account account) {
        account.setId(accountIdCounter++);
        accounts.put(account.getId(), account);
        return "Account created with ID: " + account.getId();
    }

    public Map<Long, Account> getAccounts() {
        return accounts;
    }
}