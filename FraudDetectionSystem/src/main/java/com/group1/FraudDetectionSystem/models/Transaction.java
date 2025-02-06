package com.group1.FraudDetectionSystem.models;

import java.time.LocalDateTime;

public class Transaction {

    private long id;
    private double amount;
    private boolean flagged = false;
    private LocalDateTime date;
    //private Account accountPay;
    //private Account accountReceive;

    public Transaction() {
    }

    public Transaction(long id, double amount) {
        this.id = id;
        this.amount = amount;
        //this.accountPay = accountPay;
        //this.accountReceive = accountRecieve;
        this.date= LocalDateTime.now();
        //this.execute();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

//    public Account getAccountReceive() {
//        return account1;
//    }
//
//    public void setAccountReceive(Account account) {
//        this.account1 = account;
//    }

    //    public Account getAccountPay() {
//        return AccountPay;
//    }
//
//    public void setAccountPay(Account account) {
//        this.AccountPay = account;
//    }

    //    public void execute() {
//          this.accountPay.withdraw(this.amount);
    //      this.accountReceive.deposit(this.amount);

//    }




}
