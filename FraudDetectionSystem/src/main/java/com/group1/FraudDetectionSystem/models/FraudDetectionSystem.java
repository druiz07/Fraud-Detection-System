package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.Transaction;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FraudDetectionSystem {


    public static boolean checkMultipleTransactionsInOneMinute(Account account, int maxTransactions) {
       List<Transaction> transactions = account.getTransactions();  // Asumiendo que la cuenta tiene acceso a su lista de transacciones
        LocalDateTime currentTime = LocalDateTime.now();

        long count = transactions.stream()
                .filter(transaction -> transaction.getDate().isAfter(currentTime.minusMinutes(1)))  // Transacciones dentro de los últimos 60 segundos
                .count();

        return count > maxTransactions;
    }

    public static boolean checkTransactionAmount(double amount, double limit) {
        return amount > limit;   }

    public static boolean checkMultipleTransfersToSameRecipient(Account owner, Account recipient, int maxTransfers) {
        LocalDateTime currentTime = LocalDateTime.now();
        long count = owner.getAccounts().stream()
                .filter(transaction -> transaction.getAccountReceive().equals(recipient) &&
                        transaction.getDate().isAfter(currentTime.minusMinutes(5)))  // Transacciones hacia el mismo destinatario en los últimos 5 minutos
                .count();

        return count > maxTransfers;
    }
}
