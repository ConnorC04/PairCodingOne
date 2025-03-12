package io.zipcoder;

import com.sun.tools.javac.comp.Check;

import java.util.ArrayList;

public abstract class Account implements Bank {

    private Integer accNum;
    private Double accBalance;
    private String accHolder;
    private String email;
    private Savings savings;
    private Checking checking
    private ArrayList<Transaction> transactionHistory;


    // For Business Accounts
    public Account(Integer accNum, Double accBalance, String accHolder, Savings savings){
        this.accNum = accNum;
        this.accBalance = accBalance;
        this.accHolder = accHolder;
        this.savings = savings;
    }

    public Account(Integer accNum, Double accBalance, String accHolder, Checking checking){
        this.accNum = accNum;
        this.accBalance = accBalance;
        this.accHolder = accHolder;
        this.checking = checking;
    }



    // For Personal Accounts
    public Account(Integer accNum, Double accBalance, String accHolder, String email, Integer accType){
        this.accNum = accNum;
        this.accBalance = accBalance;
        this.accHolder = accHolder;
        this.email = email;
        this.accType = accType;
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

    public void interest(Double interestRate){
        if (interestRate < 0){
            throw new IllegalArgumentException("Interest Rate cannot be negative");
        }else{
            double applyRate = this.accBalance * interestRate;
            this.accBalance += applyRate;
        }
    }

    public boolean overDraft(Double accountBalance, Double withdrawAmount){
        return (accountBalance - withdrawAmount) < 0;
    }

    public void withdraw(Double withdrawAmount) {
        if (this.accBalance < withdrawAmount ){
            throw new IllegalStateException("Insufficient funds");
        }else if (withdrawAmount < 0){
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }else {
            this.accBalance -= withdrawAmount;
        }
    }

    public void deposit(Double depositAmount){
        if (depositAmount < 0){
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }else {
            this.accBalance += depositAmount;
        }
    }
}
