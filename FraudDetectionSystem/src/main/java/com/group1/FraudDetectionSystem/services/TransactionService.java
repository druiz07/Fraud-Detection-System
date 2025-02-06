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
    private  AccountService accountService;

    public TransactionService(AccountService accountService) {
        this.accountService = accountService;
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

    public void createTransaction(long idPay, long idReceive, Transaction transaction){
        Account accountPay = null;
        Account accountReceive = null;
        for(Account acc: this.accountService.getAllAccounts()){

            if(acc.getId() == idPay){
                accountPay = acc;
            }
            else if(acc.getId() == idReceive){
                accountReceive = acc;
            }
        }
        transaction.setAccountPay(accountPay);
        transaction.setAccountReceive(accountReceive);
        transaction.setDate(LocalDateTime.now());
        this.transactions.add(transaction);
        transaction.execute();

    }


}
