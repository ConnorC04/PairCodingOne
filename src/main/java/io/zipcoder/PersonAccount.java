package io.zipcoder;

public class PersonAccount extends Account{
    public PersonAccount(Integer accountNum, Double accountBal, String accountHolder, Savings savings){
        super(accountNum, accountBal, accountHolder, savings);
    }
    public PersonAccount(Integer accountNum, Double accountBal, String accountHolder, Checking checking){
        super(accountNum, accountBal, accountHolder, checking);
    }

}
