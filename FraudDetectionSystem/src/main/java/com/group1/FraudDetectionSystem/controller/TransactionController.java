//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.services.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/transactions"})
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return this.transactionService.getAllTransactions();
    }

    @GetMapping({"/{id}"})
    public Transaction getTransactionById(@PathVariable long id) {
        return this.transactionService.getTransactionById(id);
    }

    @PostMapping
    public void createTransaction(@RequestBody Transaction transaction) {
        this.transactionService.createTransaction(transaction);
    }
}
