package com.group1.FraudDetectionSystem.models;

public class Account {
    private long id;
    private long userId;
    private double balance;

    public Account() {}

    public Account(long id, long userId, double balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public boolean withdraw(double amount){
        if(this.balance<amount){
            return false;
        }
        else{
            this.balance-=amount;
            return true;
        }
    }
}
