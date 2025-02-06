package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Transaction;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private long nextId = 1L;

    public TransactionService() {
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
        this.transactions.add(transaction);
    }
}
