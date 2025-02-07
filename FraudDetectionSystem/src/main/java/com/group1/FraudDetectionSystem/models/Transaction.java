package com.group1.FraudDetectionSystem.models;

import java.time.LocalDateTime;

/**
 * Represents a financial transaction between two accounts.
 */
public class Transaction {

    private long id;
    private double amount;
    private boolean flagged = false;
    private LocalDateTime date;
    private Account accountPay;
    private Account accountRecieve;

    /**
     * Default constructor for creating a Transaction object without setting any fields.
     */
    public Transaction() {
    }

    /**
     * Constructs a Transaction with the specified details.
     *
     * @param id the ID of the transaction
     * @param amount the amount of money transferred in the transaction
     * @param accountPay the account making the payment
     * @param accountReceive the account receiving the payment
     */
    public Transaction(long id, double amount, Account accountPay, Account accountReceive) {
        this.id = id;
        this.amount = amount;
        this.accountPay = accountPay;
        this.accountRecieve = accountReceive;
        this.date = LocalDateTime.now();
    }

    /**
     * Gets the ID of the transaction.
     *
     * @return the ID of the transaction
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the transaction.
     *
     * @param id the ID of the transaction
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the amount of money transferred in the transaction.
     *
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of money transferred in the transaction.
     *
     * @param amount the transaction amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Checks if the transaction has been flagged for fraud detection.
     *
     * @return true if the transaction is flagged, false otherwise
     */
    public boolean isFlagged() {
        return flagged;
    }

    /**
     * Sets the flagged status of the transaction.
     *
     * @param flagged the flagged status to set
     */
    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    /**
     * Gets the date and time when the transaction was created.
     *
     * @return the date and time of the transaction
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date and time when the transaction was created.
     *
     * @param date the date and time to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets the account receiving the payment in the transaction.
     *
     * @return the account receiving the payment
     */
    public Account getAccountReceive() {
        return accountRecieve;
    }

    /**
     * Sets the account receiving the payment in the transaction.
     *
     * @param account the account receiving the payment
     */
    public void setAccountReceive(Account account) {
        this.accountRecieve = account;
    }

    /**
     * Gets the account making the payment in the transaction.
     *
     * @return the account making the payment
     */
    public Account getAccountPay() {
        return accountPay;
    }

    /**
     * Sets the account making the payment in the transaction.
     *
     * @param account the account making the payment
     */
    public void setAccountPay(Account account) {
        this.accountPay = account;
    }

    /**
     * Executes the transaction by transferring the specified amount from the paying account to the receiving account.
     */
    public void execute() {
        this.accountPay.withdraw(this.amount);  // Withdraws the amount from the paying account
        this.accountRecieve.deposit(this.amount);  // Deposits the amount to the receiving account
    }
}
