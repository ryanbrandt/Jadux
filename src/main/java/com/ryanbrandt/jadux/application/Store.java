package com.ryanbrandt.jadux.application;

import java.util.HashMap;

import com.ryanbrandt.jadux.models.JaduxData;

/**
 * Defines the applications State storage
 * 
 * @author Ryan Brandt
 */
public final class Store {
    private HashMap<String, JaduxData> state;

    /**
     * Store constructor, only to be called from Jadux.createStore(). Instantiates a
     * HashMap to maintain state in the form of (String, Payload) key-values
     */
    protected Store() {
        this.state = new HashMap<String, JaduxData>();
    }

    /**
     * Store storage getter, only to be accessed via Selector and indirecty Selector
     * subclasses
     * 
     * @return The HashMap of (String, Payload) key-values maintaining state
     */
    protected HashMap<String, JaduxData> getState() {
        return this.state;
    }

    protected void updateState(HashMap<String, JaduxData> updatedState) {

    }

}