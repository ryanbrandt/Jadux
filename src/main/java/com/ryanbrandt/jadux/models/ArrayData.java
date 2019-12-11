package com.ryanbrandt.jadux.models;

import java.util.ArrayList;

/**
 * A generic ArrayList JaduxData type. Provides an ArrayList for any Object
 * subclass (String, Integer, MyObject).
 * 
 * @@author Ryan Brandt
 */
public final class ArrayData implements JaduxData {
    private ArrayList<Object> value;

    public ArrayData(ArrayList<Object> value) {
        this.value = value;
    }

    public String getType() {
        return "ArrayList<Object>";
    }

    public ArrayList<Object> getValue() {
        return this.value;
    }
}