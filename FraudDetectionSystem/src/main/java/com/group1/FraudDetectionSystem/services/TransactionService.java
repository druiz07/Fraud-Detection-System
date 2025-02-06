package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Account;
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
    AccountService accountService = new AccountService();

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

    public void createTransaction(double amount, long idPay, long idReceive){
        Account accountPay = new Account();
        Account accountRecieve = new Account();
        for(Account acc: this.accountService.getAccounts().values()){

            if(acc.getId() == idPay){
                accountPay = acc;
            }
            else if(acc.getId() == idReceive){
                accountRecieve = acc;
            }
        }
        Transaction transaction = new Transaction(nextId++, amount, accountPay, accountRecieve);
        transaction.setDate(LocalDateTime.now());
        this.transactions.add(transaction);

    }


}
