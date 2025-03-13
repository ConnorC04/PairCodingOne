package io.zipcoder;

public class BusinessAccount extends Account {

    public BusinessAccount(Integer accountNum, Double accountBal, String accountHolder, Savings savings){
        super(accountNum, accountBal, accountHolder, savings);
    }

    public BusinessAccount(Integer accountNum, Double accountBal, String accountHolder, Checking checking){
        super(accountNum, accountBal, accountHolder, checking);
    }

    public BusinessAccount(){
        super();
    }

}
