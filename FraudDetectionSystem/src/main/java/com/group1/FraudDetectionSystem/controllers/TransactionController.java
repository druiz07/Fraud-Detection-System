package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
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

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable long id) {
        return this.transactionService.getTransactionById(id);
    }

    @PostMapping("/{idPay}/{idReceive}")
    public void createTransaction(@PathVariable long idPay, @PathVariable long idReceive, @RequestBody double amount){
        this.transactionService.createTransaction(amount, idPay, idReceive);
    }

}
