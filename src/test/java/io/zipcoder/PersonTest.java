package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    private PersonAccount personsavings;
    private PersonAccount personcheckings;
    private Savings savings;
    private Checking checking;

    public void setUp() {
        personcheckings = new PersonAccount(1, 1.0, "John Doe", savings);
        personsavings = new PersonAccount(1, 1.0, "John Doe", checking);
    }
    @Test
    public void testOverDraft(){

        setUp();

        boolean expectedOverDraft = true;
        boolean expectedNotOverDraft = false;

        boolean actualOverDraft = personsavings.overDraft(70.0, 80.0);
        boolean actualNotOverDraft = personsavings.overDraft(70.0, 50.0);

        boolean actualOverDraft2 = personcheckings.overDraft(70.0, 80.0);
        boolean actualNotOverDraft2 = personcheckings.overDraft(70.0, 50.0);

        Assert.assertEquals(expectedOverDraft, actualOverDraft);
        Assert.assertEquals(expectedNotOverDraft, actualNotOverDraft);
        Assert.assertEquals(expectedOverDraft, actualOverDraft2);
        Assert.assertEquals(expectedNotOverDraft, actualNotOverDraft2);
    }
}

