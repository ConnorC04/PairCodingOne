package io.zipcoder;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private BusinessAccount businessSavings;
    private  BusinessAccount businessChecking;
    private Savings savings;
    private Checking checking;


    public void setUp(){
        businessSavings = new BusinessAccount(1, 1.0, "John Doe", savings);
        businessChecking = new BusinessAccount(1, 1.0, "John Doe", checking);
    }


    @Test
    public void testOverDraft(){

        setUp();

        boolean expectedOverDraft = true;
        boolean expectedNotOverDraft = false;

        boolean actualOverDraft = businessSavings.overDraft(70.0, 80.0);
        boolean actualNotOverDraft = businessSavings.overDraft(70.0, 50.0);

        boolean actualOverDraft2 = businessChecking.overDraft(20.0, 80.0);
        boolean actualNotOverDraft2 = businessChecking.overDraft(100.0, 50.0);

        Assert.assertEquals(expectedOverDraft, actualOverDraft);
        Assert.assertEquals(expectedNotOverDraft, actualNotOverDraft);
        Assert.assertEquals(expectedOverDraft, actualOverDraft2);
        Assert.assertEquals(expectedNotOverDraft, actualNotOverDraft2);
    }

    @Test
    public void testInsufficientFunds(){
        setUp();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            businessSavings.withdraw(50.0);
        });

        String expectedMessage = "Insufficient funds";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, businessSavings.getAccBalance());
    }

    @Test
    public void testWithdrawNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            businessSavings.withdraw(-1.0);
        });

        String expectedMessage = "Withdrawal amount cannot be negative";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, businessSavings.getAccBalance());
    }

    @Test
    public void testWithdraw(){
        setUp();
        businessSavings.withdraw(1.0);
        assertEquals(0.0, businessSavings.getAccBalance());
    }

    @Test
    public void testDepositNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            businessSavings.deposit(-1.0);
        });
        String expectedMessage = "Deposit amount cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, businessSavings.getAccBalance());
    }

    @Test
    public void testDeposit(){
        setUp();
        businessSavings.deposit(1.0);
        assertEquals(2.0, businessSavings.getAccBalance());
    }

    @Test
    public void testInterestNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            businessSavings.interest(-1.0);
        });
        String expectedMessage = "Interest Rate cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, businessSavings.getAccBalance());


        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            businessChecking.deposit(-5.0);
        });
        String expectedMessage2 = "Interest Rate cannot be negative";
        String actualMessage2 = exception.getMessage();
        assertTrue(expectedMessage2.contains(actualMessage2));
        assertEquals(1, businessChecking.getAccBalance());
    }

    @Test
    public void testInterest(){
        setUp();

        businessSavings.interest(0.07);
        businessChecking.interest(0.08);

        Double expectedSavings = 1.07;
        Double expectedChecking = 1.08;

        assertEquals(expectedChecking, businessChecking.getAccBalance());
        assertEquals(expectedSavings, businessSavings.getAccBalance());
    }

    @Test
    public void testAddTransaction(){
        setUp();

        businessChecking.deposit(1.0);
        businessSavings.deposit(1.0);
       // businessSavings.addTransaction();
    }


}
