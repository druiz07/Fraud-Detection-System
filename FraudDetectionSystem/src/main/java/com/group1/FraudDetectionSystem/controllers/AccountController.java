package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.User;
import com.group1.FraudDetectionSystem.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller for handling account-related operations.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    /**
     * Constructor to initialize AccountService.
     * @param accountService The service handling account logic.
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Retrieves all accounts.
     * @return A collection of all accounts.
     */
    @GetMapping
    public Collection<Account> getAllUsers() {
        return this.accountService.getAllAccounts();
    }

    /**
     * Creates a new account.
     * @param account The account details.
     * @return A confirmation message with account ID.
     */
    @PostMapping()
    public String createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

}