package com.ryanbrandt.jadux.models;

public final class IntegerData implements Data {
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