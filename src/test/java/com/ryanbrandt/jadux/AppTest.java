package com.ryanbrandt.jadux;

import static org.junit.Assert.fail;

import com.ryanbrandt.jadux.application.Action;
import com.ryanbrandt.jadux.application.ActionTypeDoesNotExistException;
import com.ryanbrandt.jadux.application.Jadux;
import com.ryanbrandt.jadux.application.StoreAlreadyExistsException;
import com.ryanbrandt.jadux.application.UniqueActionException;
import com.ryanbrandt.jadux.application.UniqueActionTypeReferenceException;
import com.ryanbrandt.jadux.application.UniqueReducerReferenceException;
import com.ryanbrandt.jadux.reducer.Reducer;

import org.junit.Test;

/**
 * Master Application Tests. If this fails, everything is fucked.
 * 
 * Coverage: Store Creation, ActionType Creation/Registration, Reducer
 * Creation/Registration
 * 
 * @author Ryan Brandt
 */
public class AppTest {

    /**
     * JUnit doesn't let you run tests with order! This is an anti-pattern!
     */
    @Test
    public void AppTestMain() {
        shouldCreateSingletonStore();
        shouldCreateUniqueActionTypes();
        shouldCreateUniqueActionsWithExistingActionTypes();
        shouldCreateUniqueReducersByReference();
    }

    public void shouldCreateSingletonStore() {
        try {
            Jadux.createStore();
        } catch (StoreAlreadyExistsException e) {
            fail("Test threw StoreAlreadyExistsException when a store does not exist");
        }

        try {
            Jadux.createStore();
            fail("Test failed to throw StoreAlreadyExistsException when a store already exists");
        } catch (StoreAlreadyExistsException e) {

        }

    }

    public void shouldCreateUniqueActionTypes() {
        try {
            Jadux.registerActionType("MY_TEST_ACTION_TYPE");
        } catch (UniqueActionTypeReferenceException e) {
            fail("Test threw UniqueActionTypeReferenceException when ActionType does not exist");
        }

        try {
            Jadux.registerActionType("MY_TEST_ACTION_TYPE");
            fail("Test failed to throw UniqueActionTypeReferenceEXception when ActionType already exists");
        } catch (UniqueActionTypeReferenceException e) {

        }

    }

    public void shouldCreateUniqueActionsWithExistingActionTypes() {
        try {
            Jadux.registerAction("MY_TEST_ACTION_TYPE");
        } catch (UniqueActionException | ActionTypeDoesNotExistException e) {
            fail("Test threw " + e.getClass().getName() + " when ActionType was registered and Action was unique");
        }

        try {
            Jadux.registerAction("MY_TEST_ACTION_TYPE");
            fail("Test failed to throw an exception when Action was already registered");
        } catch (UniqueActionException | ActionTypeDoesNotExistException e) {

        }

        try {
            Jadux.registerAction("AN_UNREGISTERED_ACTION_TYPE");
            fail("Test failed to throw ActionTypeDoesNotExistException when associated ActionType does not exist");
        } catch (UniqueActionException | ActionTypeDoesNotExistException e) {

        }
    }

    private class TestReducer implements Reducer {

        public void reduce(Action a) {

        }
    }

    public void shouldCreateUniqueReducersByReference() {
        try {
            Jadux.registerReducer("myTestReducer", new TestReducer());
        } catch (UniqueReducerReferenceException e) {
            fail("Test threw a UniqueReducerReferenceException when Reducer does not exist");
        }

        try {
            Jadux.registerReducer("myTestReducer", new TestReducer());
            fail("Test failed to throw a UniqueReducerReferenceException when Reducer already exists");
        } catch (UniqueReducerReferenceException e) {

        }
    }

}
