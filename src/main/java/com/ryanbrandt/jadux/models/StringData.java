package com.ryanbrandt.jadux.models;

public final class StringData implements Data {
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