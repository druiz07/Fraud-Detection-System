package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.FraudDetectionSystem;
import com.group1.FraudDetectionSystem.models.Transaction;
import com.group1.FraudDetectionSystem.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudDetectionService {


    private TransactionService transactionService;
    private UserService userService;
    private FraudDetectionSystem fraudDetectionSystem;

    public FraudDetectionService(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.fraudDetectionSystem = new FraudDetectionSystem(transactionService);
        this.userService = userService;
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
        for (Transaction transaction : this.transactionService.getAllTransactions()) {

            if (fraudDetectionSystem.checkMultipleTransactionsInOneMinute(transaction.getAccountPay(), 5)) {
                transaction.setFlagged(true);
            }


            if (fraudDetectionSystem.checkTransactionAmount(transaction.getAmount(), 5000)) {
                transaction.setFlagged(true);
            }
            for(User user: this.userService.getAllUsers()) {
                if (fraudDetectionSystem.checkMultipleTransfersToSameRecipient(user,
                        transaction.getAccountReceive(), 3)) {
                    transaction.setFlagged(true);
                }
            }
        }
    }
}
