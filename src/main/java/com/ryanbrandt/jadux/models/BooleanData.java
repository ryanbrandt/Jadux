package com.ryanbrandt.jadux.models;

public final class BooleanData implements Data {
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