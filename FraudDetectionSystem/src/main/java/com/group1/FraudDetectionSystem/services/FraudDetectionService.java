package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.FraudDetectionSystem;
import com.group1.FraudDetectionSystem.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudDetectionService {

    private final List<Transaction> transactions;
    private TransactionService transactionService;
    private FraudDetectionSystem fraudDetectionSystem;

    public FraudDetectionService(List<Transaction> transactions, TransactionService transactionService) {
        this.transactions = transactions;
        startFraudDetection();
        this.fraudDetectionSystem = new FraudDetectionSystem(transactionService);


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

            if (fraudDetectionSystem.checkMultipleTransactionsInOneMinute(transaction.getAccountPay(), 5)) {
                transaction.setFlagged(true);
            }


            if (fraudDetectionSystem.checkTransactionAmount(transaction.getAmount(), 5000)) {
                transaction.setFlagged(true);
            }

//            if (fraudDetectionSystem.checkMultipleTransfersToSameRecipient(transaction.getAccountPay(),
//                    transaction.getAccountReceive(), 3)) {
//                transaction.setFlagged(true);
//            }
        }
    }
}
