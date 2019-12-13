package com.ryanbrandt.jadux;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Main test driver. Runs suite.
 * 
 * @author Ryan Brandt
 */
public class TestDriver {
    @Test
    public void main() {
        Result result = JUnitCore.runClasses(AppTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println("\n ******** TEST FAILED @ " + failure.toString() + " ******** \n");
        }
        if (!result.wasSuccessful()) {
            fail("Some tests in this suite did not pass");
        }
    }
}