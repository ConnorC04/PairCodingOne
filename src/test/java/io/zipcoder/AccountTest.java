package io.zipcoder;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

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
    public void testWithdraw(){

        setUp();

        Double expectedWithdrawn = 20.0;




    }
}
