package com.niit.idbcbank;

public class Account {

    private String accountNo;
    private String accountType;
    private int customerId;
    private double accountBalance;
    private int amount;

    public Account(String accountNo, String accountType, int customerId, double accountBalance, int amount) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.customerId = customerId;
        this.accountBalance = accountBalance;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
