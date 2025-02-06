package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudDetectionService {

    private final List<Transaction> transactions;

    public FraudDetectionService(List<Transaction> transactions) {
        this.transactions = transactions;
        startFraudDetection();
    }

    private void startFraudDetection() {
        Runnable fraudDetectionTask = () -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    checkFraudulentTransactions();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };


        new Thread(fraudDetectionTask).start();
    }


    public void checkFraudulentTransactions() {
        for (Transaction transaction : transactions) {

            if (FraudDetectionSystem.checkMultipleTransactionsInOneMinute(transaction.getAccountPay(), 5)) {
                transaction.setFlagged(true);
            }


            if (FraudDetectionSystem.checkTransactionAmount(transaction.getAmount(), 5000)) {
                transaction.setFlagged(true);
            }

            if (FraudDetectionSystem.checkMultipleTransfersToSameRecipient(transaction.getAccountPay().getOwner(),
                    transaction.getAccountReceive(), 3)) {
                transaction.setFlagged(true);
            }
        }
    }
}
