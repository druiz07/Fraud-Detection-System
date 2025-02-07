package com.group1.FraudDetectionSystem.models;

/**
 * Represents a bank account.
 */
public class Account {
    private long id;
    private long userId;
    private double balance;

    /**
     * Default constructor.
     */
    public Account() {}

    /**
     * Constructs an account with given details.
     * @param id Account ID.
     * @param userId Associated user ID.
     * @param balance Initial balance.
     */
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

    /**
     * Deposits a specified amount.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount){
        this.balance += amount;
    }

    /**
     * Withdraws a specified amount if balance is sufficient.
     * @param amount The amount to withdraw.
     * @return True if withdrawal is successful, otherwise false.
     */
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
