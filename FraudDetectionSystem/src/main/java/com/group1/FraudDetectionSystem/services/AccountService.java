package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {
    private final Map<Long, Account> accounts = new HashMap<>();
    private long accountIdCounter = 1;


    public AccountService() {
        Account acc1 = new Account(accountIdCounter++, 1, 500);
        Account acc2 = new Account(accountIdCounter++, 1, 700);
        this.accounts.put(acc1.getId(), acc1);
        this.accounts.put(acc2.getId(), acc2);
    }

    public String createAccount(Account account) {
        account.setId(accountIdCounter++);
        accounts.put(account.getId(), account);
        return "Account created with ID: " + account.getId();
    }

    public Collection<Account> getAllAccounts(){return this.accounts.values();}

    public Map<Long, Account> getAccounts() {
        return accounts;
    }
}