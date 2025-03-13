package io.zipcoder;

public class Transaction {

    private String thisType;
    private Double thisAmount;

    public Transaction(String type, Double amount){
        this.thisAmount = amount;
        this.thisType = type;
    }
}