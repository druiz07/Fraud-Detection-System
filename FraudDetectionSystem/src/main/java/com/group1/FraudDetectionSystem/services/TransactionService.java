package com.group1.FraudDetectionSystem.services;

import com.group1.FraudDetectionSystem.models.Account;
import com.group1.FraudDetectionSystem.models.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
    public void simulateTransactions() {
        Runnable transactionSimulator = () -> {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(5000));
                    long idPay = random.nextInt(10) + 1;
                    long idReceive = random.nextInt(10) + 1;
                    double amount = random.nextDouble() * 10000;


                    Transaction transaction = new Transaction(nextId++, amount, null, null);
                    createTransaction(idPay, idReceive, transaction);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };


        new Thread(transactionSimulator).start();
    }


    public List<Transaction> getTransactionsOfAccount(long id){
        List<Transaction> transactions = new ArrayList<>();
        for(Transaction trans: this.transactions){
            if(trans.getAccountReceive().getId() == id || trans.getAccountPay().getId() == id){
                transactions.add(trans);
            }
        }
        return transactions;
    }
}
