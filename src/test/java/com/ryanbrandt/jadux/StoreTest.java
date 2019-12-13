package com.ryanbrandt.jadux;

import static org.junit.Assert.fail;

import com.ryanbrandt.jadux.application.Jadux;
import com.ryanbrandt.jadux.application.StoreAlreadyExistsException;

import org.junit.Test;

/**
 * Store testing
 * 
 * Coverage: Store Creation & singleton enforcement
 * 
 * @author Ryan Brandt
 */
public class StoreTest {

    @Test
    public void shouldCreateSingletonStore() {
        try {
            Jadux.createStore();
        } catch (StoreAlreadyExistsException e) {
            fail("Application threw StoreAlreadyExistsException when a store does not exist");
        }

        try {
            Jadux.createStore();
            fail("Application failed to throw StoreAlreadyExistsException when a store already exists");
        } catch (StoreAlreadyExistsException e) {

        }

    }

}