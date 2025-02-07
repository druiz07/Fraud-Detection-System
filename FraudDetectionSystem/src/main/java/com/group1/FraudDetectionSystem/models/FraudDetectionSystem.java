package com.group1.FraudDetectionSystem.models;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.services.TransactionService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FraudDetectionSystem {

    private TransactionService transactionService;

    public FraudDetectionSystem(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public boolean checkMultipleTransactionsInOneMinute(Account account, int maxTransactions) {
        List<Transaction> transactions = this.transactionService.getTransactionsOfAccount(account.getId());  // Asumiendo que la cuenta tiene acceso a su lista de transacciones
        LocalDateTime currentTime = LocalDateTime.now();

        long count = transactions.stream()
                .filter(transaction -> transaction.getDate().isAfter(currentTime.minusMinutes(1)))  // Transacciones dentro de los últimos 60 segundos
                .count();

        return count > maxTransactions;
    }

    public boolean checkTransactionAmount(double amount, double limit) {
        return amount > limit;
    }

    public boolean checkMultipleTransfersToSameRecipient(User owner, Account recipient, int maxTransfers) {
        LocalDateTime currentTime = LocalDateTime.now();
        long count = this.transactionService.getAllTransactions().stream().filter(transaction -> transaction.getAccountPay().getUserId() == owner.getId()).filter(transaction -> transaction.getAccountReceive().equals(recipient) &&
                        transaction.getDate().isAfter(currentTime.minusMinutes(5)))  // Transacciones hacia el mismo destinatario en los últimos 5 minutos
                .count();


        return count > maxTransfers;
    }
}
