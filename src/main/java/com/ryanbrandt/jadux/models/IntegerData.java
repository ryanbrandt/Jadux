package com.ryanbrandt.jadux.models;

/**
 * A generic integer JaduxData type.
 * 
 * @author Ryan Brandt
 */
public final class IntegerData implements JaduxData {
    private Integer value;

    public IntegerData(int value) {
        this.value = value;
    }

    public String getType() {
        return "Integer";
    }

    public Integer getValue() {
        return this.value;
    }
}