//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Transaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList();
    private long nextId = 1L;

    public TransactionService() {
        this.transactions.add(new Transaction((long)(this.nextId++), (double)5000.0F));
        this.transactions.add(new Transaction((long)(this.nextId++), (double)2000.0F));
    }

    public List<Transaction> getAllTransactions() {
        return this.transactions;
    }

    public Transaction getTransactionById(long id) {
        for(Transaction transaction : this.transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }

        return null;
    }

    public void createTransaction(Transaction transaction) {
        transaction.setId((long)(this.nextId++));
        transaction.setDate(LocalDateTime.now());
        this.transactions.add(transaction);
    }
}
