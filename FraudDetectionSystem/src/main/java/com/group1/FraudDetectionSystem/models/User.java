package com.group1.FraudDetectionSystem.models;

/**
 * Represents a bank user.
 */
public class User {
    private long id;
    private String name;
    private double monthlyIncome;
    private int creditScore;

    /**
     * Default constructor.
     */
    public User() {}

    /**
     * Constructs a user with given details.
     * @param id User ID.
     * @param name User's name.
     * @param monthlyIncome Monthly income of the user.
     * @param creditScore Credit score of the user.
     */
    public User(long id, String name, double monthlyIncome, int creditScore) {
        this.id = id;
        this.name = name;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
