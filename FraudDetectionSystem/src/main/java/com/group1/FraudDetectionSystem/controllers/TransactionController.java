package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing transactions.
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * Constructs a TransactionController with the given TransactionService.
     *
     * @param transactionService the service that handles transaction logic
     */
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Retrieves all transactions.
     *
     * @return a List of all transactions
     */
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return this.transactionService.getAllTransactions();
    }

    /**
     * Retrieves a transaction by its ID.
     *
     * @param id the ID of the transaction to retrieve
     * @return the Transaction with the specified ID
     */
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable long id) {
        return this.transactionService.getTransactionById(id);
    }

    /**
     * Creates a new transaction.
     *
     * @param idPay the ID of the account making the payment
     * @param idReceive the ID of the account receiving the payment
     * @param transaction the details of the transaction to create
     */
    @PostMapping("/{idPay}/{idReceive}")
    public void createTransaction(@PathVariable("idPay") long idPay, @PathVariable("idReceive") long idReceive, @RequestBody Transaction transaction) {
        this.transactionService.createTransaction(idPay, idReceive, transaction);
    }

    /**
     * Starts a simulation of transactions.
     */
    @GetMapping("/startSimulation")
    public void startSimulation() {
        this.transactionService.simulateTransactions();
    }
}
