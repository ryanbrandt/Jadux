package com.ryanbrandt.jadux;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.ryanbrandt.jadux.action.Action;
import com.ryanbrandt.jadux.application.ActionDoesNotExistException;
import com.ryanbrandt.jadux.application.Jadux;
import com.ryanbrandt.jadux.application.UniqueActionException;
import com.ryanbrandt.jadux.models.IntegerData;
import com.ryanbrandt.jadux.models.StringData;

/**
 * Action tests
 * 
 * coverage: Action creation, payload setting, type enforcement
 * 
 * @author Ryan Brandt
 */
public class ActionTest {
    public final static String TEST_ACTION = "TEST_ACTION";
    public final static String INTEGER_DATA_ACTION = "TEST_INTEGER_DATA_ACTION";
    public final static String STRING_DATA_ACTION = "TEST_STRING_DATA_ACTION";

    @Test
    public void shouldCreateUniqueActions() {
        try {
            Jadux.registerAction(new Action<IntegerData>(TEST_ACTION));
        } catch (UniqueActionException e) {
            fail("Application threw UniqueActionException when registered Action was unique");
        }

        try {
            Jadux.registerAction(new Action<IntegerData>(TEST_ACTION));
            fail("Application failed to throw UniqueActionException when registered Action was not unique");
        } catch (UniqueActionException e) {

        }
    }

    @Test
    public void shouldSetActionPayload() {
        try {
            Jadux.registerAction(new Action<IntegerData>(INTEGER_DATA_ACTION));
            Jadux.getApplicationAction(INTEGER_DATA_ACTION).setPayload(new IntegerData(1));
        } catch (ActionDoesNotExistException | UniqueActionException | IllegalArgumentException e) {
            fail("Application failed to set Action payload with " + e.getMessage());
        }
    }

    /**
     * @see FIX ME! Java sucks for generics!
     */
    @Ignore
    public void shouldEnforceParameterizedType() {
        try {
            Jadux.registerAction(new Action<StringData>(STRING_DATA_ACTION));
            Jadux.getApplicationAction(STRING_DATA_ACTION).setPayload(new IntegerData(1));
            fail("Application failed to enforce Action parameterized type at run time");
        } catch (ActionDoesNotExistException | UniqueActionException | IllegalArgumentException e) {

        }
    }
}