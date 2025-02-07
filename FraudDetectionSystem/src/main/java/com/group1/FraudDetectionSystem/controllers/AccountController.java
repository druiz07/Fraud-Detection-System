package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.User;
import com.group1.FraudDetectionSystem.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Collection<Account> getAllUsers() {
        return this.accountService.getAllAccounts();
    }

    @PostMapping()
    public String createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

}