package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Transaction;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private long nextId = 1L;

    public TransactionService() {
        this.transactions.add(new Transaction(this.nextId++, 5000));
        this.transactions.add(new Transaction(this.nextId++, 2000));
    }


    public List<Transaction> getAllTransactions(){return this.transactions;}

    public Transaction getTransactionById(long id){
        for(Transaction transaction: this.transactions){
            if (transaction.getId()==id){
                return  transaction;
            }
        }
        return null;
    }

    public void createTransaction(Transaction transaction){
        transaction.setId(nextId++);
        transaction.setDate(LocalDateTime.now());
        this.transactions.add(transaction);

    }
}
