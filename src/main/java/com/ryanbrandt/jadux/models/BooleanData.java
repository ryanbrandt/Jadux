package com.ryanbrandt.jadux.models;

/**
 * A generic boolean JaduxData type.
 * 
 * @author Ryan Brandt
 */
public final class BooleanData implements JaduxData {
    private Boolean value;

    public BooleanData(Boolean value) {
        this.value = value;
    }

    public String getType() {
        return "Boolean";
    }

    public Boolean getValue() {
        return this.value;
    }
}