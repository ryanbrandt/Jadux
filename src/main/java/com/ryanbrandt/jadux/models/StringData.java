package com.ryanbrandt.jadux.models;

/**
 * Generic string JaduxData type.
 * 
 * @author Ryan Brandt
 */
public final class StringData implements JaduxData {
    private String value;

    public StringData(String value) {
        this.value = value;
    }

    public String getType() {
        return "String";
    }

    public String getValue() {
        return this.value;
    }
}