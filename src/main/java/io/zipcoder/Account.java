package io.zipcoder;

import java.util.ArrayList;

public abstract class Account implements Bank {

    private Integer accNum;
    private Double accBalance;
    private String accHolder;
    private String email;
    private ArrayList<Transaction> transactionHistory;


    // For Business Accounts
    public Account(Integer accNum, Double accBalance, String accHolder){
        this.accNum = accNum;
        this.accBalance = accBalance;
        this.accHolder = accHolder;
    }

    // For Personal Accounts
    public Account(Integer accNum, Double accBalance, String accHolder, String email){
        this.accNum = accNum;
        this.accBalance = accBalance;
        this.accHolder = accHolder;
        this.email = email;
    }

    public Integer getAccNum() { return accNum; }

    public Double getAccBalance() {
        return accBalance;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public String getEmail(){ return email; }

    public void setAccNum(Integer accNum){
        this.accNum = accNum;
    }

    public void setAccBalance(Double accBalance) {
        this.accBalance = accBalance;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumTransactions() { return transactionHistory.size(); }

    public void addTransaction(Transaction transaction) { transactionHistory.add(transaction); }

    public Double interest(Double accountBalance, Double interestRate){
        double newBalance = accountBalance * interestRate;
        newBalance += accountBalance;
        return newBalance;
    }

    public boolean overDraft(Double accountBalance, Double withdrawAmount){
        return (accountBalance - withdrawAmount) < 0;
    }

    public Double withdraw(Double accountBalance, Double withdrawAmount) throws Exception {
        if (overDraft(accountBalance, withdrawAmount)) {
            throw new Exception("Insufficient Funds!");
        }
        return accountBalance - withdrawAmount;
    }
}
