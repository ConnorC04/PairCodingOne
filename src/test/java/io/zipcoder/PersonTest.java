package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private PersonAccount personsavings;
    private PersonAccount personcheckings;
    private Savings savings;
    private Checking checking;

    public void setUp() {
        personcheckings = new PersonAccount(1, 1.0, "John Doe", savings);
        personsavings = new PersonAccount(1, 1.0, "John Doe", checking);
    }
//    @Test
//    public void testOverDraft(){
//
//        setUp();
//
//        boolean expectedOverDraft = true;
//        boolean expectedNotOverDraft = false;
//
//        boolean actualOverDraft = personsavings.overDraft(70.0, 80.0);
//        boolean actualNotOverDraft = personsavings.overDraft(70.0, 50.0);
//
//        boolean actualOverDraft2 = personcheckings.overDraft(70.0, 80.0);
//        boolean actualNotOverDraft2 = personcheckings.overDraft(70.0, 50.0);
//
//        Assert.assertEquals(expectedOverDraft, actualOverDraft);
//        Assert.assertEquals(expectedNotOverDraft, actualNotOverDraft);
//        Assert.assertEquals(expectedOverDraft, actualOverDraft2);
//        Assert.assertEquals(expectedNotOverDraft, actualNotOverDraft2);
//    }
    @Test
    public void testInsufficientFunds(){
        setUp();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            personcheckings.withdraw(50.0);
        });

        String expectedMessage = "Insufficient funds";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, personcheckings.getAccBalance());
    }
    @Test
    public void testWithdrawNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personcheckings.withdraw(-1.0);
        });

        String expectedMessage = "Withdrawal amount cannot be negative";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, personcheckings.getAccBalance());
    }
    @Test
    public void testWithdraw(){
        setUp();
        personcheckings.withdraw(1.0);
        assertEquals(0.0, personcheckings.getAccBalance());
    }

    @Test
    public void testDepositNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personcheckings.deposit(-1.0);
        });
        String expectedMessage = "Deposit amount cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, personcheckings.getAccBalance());
    }

    @Test
    public void testDeposit(){
        setUp();
        personcheckings.deposit(1.0);
        assertEquals(2.0,  personcheckings.getAccBalance());
    }

    @Test
    public void testInterestNegative(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personcheckings.interest(-1.0);
        });
        String expectedMessage = "Interest Rate cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, personcheckings.getAccBalance());


        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            personcheckings.deposit(-5.0);
        });
        String expectedMessage2 = "Interest Rate cannot be negative";
        String actualMessage2 = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage2));
        assertEquals(1,personcheckings.getAccBalance());
    }
    @Test
    public void testWithdrawSave(){
        setUp();
        personsavings.withdraw(1.0);
        assertEquals(0.0, personsavings.getAccBalance());
    }

    @Test
    public void testDepositNegativeSave(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personsavings.deposit(-1.0);
        });
        String expectedMessage = "Deposit amount cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, personsavings.getAccBalance());
    }

    @Test
    public void testDepositSave(){
        setUp();
        personsavings.deposit(1.0);
        assertEquals(2.0, personsavings.getAccBalance());
    }

    @Test
    public void testInterestNegativeSave(){
        setUp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personsavings.interest(-1.0);
        });
        String expectedMessage = "Interest Rate cannot be negative";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
        assertEquals(1, personsavings.getAccBalance());


        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            personsavings.deposit(-5.0);
        });
        String expectedMessage2 = "Interest Rate cannot be negative";
        String actualMessage2 = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage2));
        assertEquals(1, personsavings.getAccBalance());
    }
}

