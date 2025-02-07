package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Service class responsible for managing transactions.
 */
@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private long nextId = 1L;
    private AccountService accountService;

    /**
     * Constructs a TransactionService with the given AccountService.
     *
     * @param accountService the service responsible for managing accounts
     */
    public TransactionService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Retrieves all transactions in the system.
     *
     * @return a List of all transactions
     */
    public List<Transaction> getAllTransactions() {
        return this.transactions;
    }

    /**
     * Retrieves a transaction by its ID.
     *
     * @param id the ID of the transaction
     * @return the Transaction with the specified ID, or null if not found
     */
    public Transaction getTransactionById(long id) {
        for (Transaction transaction : this.transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    /**
     * Creates a new transaction between two accounts.
     *
     * @param idPay the ID of the account making the payment
     * @param idReceive the ID of the account receiving the payment
     * @param transaction the details of the transaction to create
     */
    public void createTransaction(long idPay, long idReceive, Transaction transaction) {
        Account accountPay = null;
        Account accountReceive = null;

        // Retrieve accounts based on their IDs
        for (Account acc : this.accountService.getAllAccounts()) {
            if (acc.getId() == idPay) {
                accountPay = acc;
            } else if (acc.getId() == idReceive) {
                accountReceive = acc;
            }
        }

        // Set transaction details
        transaction.setId(nextId++);
        transaction.setAccountPay(accountPay);
        transaction.setAccountReceive(accountReceive);
        transaction.setDate(LocalDateTime.now());

        // Add transaction to the list and execute it
        this.transactions.add(transaction);
        transaction.execute();
    }

    /**
     * Simulates the creation of random transactions.
     *
     */
    public void simulateTransactions() {
        Runnable transactionSimulator = () -> {
            Random random = new Random();
            while (true) {
                try {
                    // Sleep for a random amount of time before creating the next transaction
                    Thread.sleep(random.nextInt(5000));

                    // Generate random account IDs and transaction amount
                    long idPay = random.nextInt(10) + 1;
                    long idReceive = random.nextInt(10) + 1;
                    double amount = random.nextDouble() * 10000;

                    // Create and execute the transaction
                    Transaction transaction = new Transaction(nextId++, amount, null, null);
                    createTransaction(idPay, idReceive, transaction);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Start the transaction simulation in a new thread
        new Thread(transactionSimulator).start();
    }

    /**
     * Retrieves all transactions associated with a specific account.
     *
     * @param id the ID of the account to retrieve transactions for
     * @return a List of transactions associated with the specified account
     */
    public List<Transaction> getTransactionsOfAccount(long id) {
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction trans : this.transactions) {
            if (trans.getAccountReceive().getId() == id || trans.getAccountPay().getId() == id) {
                accountTransactions.add(trans);
            }
        }
        return accountTransactions;
    }
}
