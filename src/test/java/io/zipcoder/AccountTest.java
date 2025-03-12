package io.zipcoder;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private BusinessAccount businessAccount;


    public void setUp(){
        businessAccount = new BusinessAccount(1, 1.0, "John Doe");
    }


    @Test
    public void testOverDraft(){

        setUp();

        boolean expectedOverDraft = true;
        boolean expectedNotOverDraft = false;

        boolean actualOverDraft = businessAccount.overDraft(70.0, 80.0);
        boolean actualNotOverDraft = businessAccount.overDraft(70.0, 50.0);

        Assert.assertEquals(expectedOverDraft, actualOverDraft);
        Assert.assertEquals(expectedNotOverDraft, actualNotOverDraft);
    }

    @Test
    public void testInsufficientFunds(){
        setUp();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            businessAccount.withdraw(50.0);
        });

        String expectedMessage = "Insufficient funds";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, businessAccount.getAccBalance());
    }

    @Test
    public void testWithdrawNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            businessAccount.withdraw(-1.0);
        });

        String expectedMessage = "Withdrawal amount cannot be negative";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, businessAccount.getAccBalance());
    }

    @Test
    public void testWithdraw(){
        setUp();
        businessAccount.withdraw(1.0);
        assertEquals(0.0, businessAccount.getAccBalance());
    }

    @Test
    public void testDepositNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            businessAccount.deposit(-1.0);
        });
        String expectedMessage = "Deposit amount cannot be negative";
        String actualMesage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMesage));
        assertEquals(1, businessAccount.getAccBalance());
    }

    @Test
    public void testDeposit(){
        setUp();
        businessAccount.deposit(1.0);
        assertEquals(2.0, businessAccount.getAccBalance());
    }
}
