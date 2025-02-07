package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.FraudDetectionSystem;
import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for performing fraud detection on transactions.
 */
@Service
public class FraudDetectionService {

    private TransactionService transactionService;
    private UserService userService;
    private FraudDetectionSystem fraudDetectionSystem;

    /**
     * Constructs a FraudDetectionService with the provided TransactionService and UserService.
     *
     * @param transactionService the service responsible for retrieving transactions
     * @param userService the service responsible for retrieving users
     */
    public FraudDetectionService(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.fraudDetectionSystem = new FraudDetectionSystem(transactionService);
        this.userService = userService;
        startFraudDetection();
    }

    /**
     * Starts a background task that periodically checks for fraudulent transactions every 10 seconds.
     */
    private void startFraudDetection() {
        Runnable fraudDetectionTask = () -> {
            while (true) {
                try {
                    Thread.sleep(10000);  // Wait for 10 seconds before checking again
                    checkFraudulentTransactions();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        new Thread(fraudDetectionTask).start();
    }

    /**
     * Checks all transactions for fraudulent activity based on predefined criteria.
     */
    public void checkFraudulentTransactions() {
        // Iterate over all transactions to check for potential fraud
        for (Transaction transaction : this.transactionService.getAllTransactions()) {

            // Check for multiple transactions in one minute for the account making the payment
            if (fraudDetectionSystem.checkMultipleTransactionsInOneMinute(transaction.getAccountPay(), 5)) {
                transaction.setFlagged(true);  // Flag the transaction if fraudulent
            }

            // Check if the transaction amount exceeds the threshold of 5000
            if (fraudDetectionSystem.checkTransactionAmount(transaction.getAmount(), 5000)) {
                transaction.setFlagged(true);  // Flag the transaction if fraudulent
            }

            // Check if there have been multiple transfers to the same recipient by any user
            for (User user : this.userService.getAllUsers()) {
                fraudDetectionSystem.checkMultipleTransfersToSameRecipient(user, transaction.getAccountReceive(), 3);



            }
        }
    }
}
