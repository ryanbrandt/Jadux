package com.ryanbrandt.jadux.application;

import java.util.HashMap;

import com.ryanbrandt.jadux.models.Payload;;

/**
 * Defines the applications State storage
 * 
 * @author Ryan Brandt
 */
public final class Store {
    private HashMap<String, Payload> storage;

    /**
     * Store constructor, only to be called from Jadux.createStore(). Instantiates a
     * HashMap to maintain state in the form of (String, Payload) key-values
     */
    protected Store() {
        this.storage = new HashMap<String, Payload>();
    }

    /**
     * Store storage getter, only to be accessed via Selector and indirecty Selector
     * subclasses
     * 
     * @return The HashMap of (String, Payload) key-values maintaining state
     */
    protected HashMap<String, Payload> getStore() {
        return this.storage;
    }

}