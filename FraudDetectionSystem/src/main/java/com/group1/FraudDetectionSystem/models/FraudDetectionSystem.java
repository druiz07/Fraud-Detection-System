package com.group1.FraudDetectionSystem.models;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.services.TransactionService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The FraudDetectionSystem class
 */
public class FraudDetectionSystem {

    private TransactionService transactionService;

    /**
     * Constructs a FraudDetectionSystem with the given TransactionService.
     *
     * @param transactionService the service to retrieve transaction data
     */
    public FraudDetectionSystem(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Checks if an account has made more than a specified number of transactions within the last minute.
     *
     * @param account the account to check for multiple transactions
     * @param maxTransactions the maximum number of transactions allowed in one minute
     * @return true if the number of transactions exceeds the limit, false otherwise
     */
    public boolean checkMultipleTransactionsInOneMinute(Account account, int maxTransactions) {
        List<Transaction> transactions = this.transactionService.getTransactionsOfAccount(account.getId());  // Get account's transactions
        LocalDateTime currentTime = LocalDateTime.now();

        long count = transactions.stream()
                .filter(transaction -> transaction.getDate().isAfter(currentTime.minusMinutes(1)))  // Transactions within the last 60 seconds
                .count();

        return count > maxTransactions;
    }

    /**
     * Checks if a transaction amount exceeds a specified limit.
     *
     * @param amount the transaction amount to check
     * @param limit the threshold limit
     * @return true if the transaction amount exceeds the limit, false otherwise
     */
    public boolean checkTransactionAmount(double amount, double limit) {
        return amount > limit;
    }

    /**
     * Checks if an owner has made more than a specified number of transfers to the same recipient in the last 5 minutes.
     *
     * @param owner the user who owns the account making the transfers
     * @param recipient the recipient account of the transfers
     * @param maxTransfers the maximum number of allowed transfers to the same recipient in the last 5 minutes
     * @return true if the number of transfers exceeds the limit, false otherwise
     */
    public boolean checkMultipleTransfersToSameRecipient(User owner, Account recipient, int maxTransfers) {
        LocalDateTime currentTime = LocalDateTime.now();
        long count = this.transactionService.getAllTransactions().stream()
                .filter(transaction -> transaction.getAccountPay().getUserId() == owner.getId())  // Filter by the owner's user ID
                .filter(transaction -> transaction.getAccountReceive().equals(recipient) &&
                        transaction.getDate().isAfter(currentTime.minusMinutes(5)))  // Filter by recipient and transactions in the last 5 minutes
                .count();

        return count > maxTransfers;
    }
}
