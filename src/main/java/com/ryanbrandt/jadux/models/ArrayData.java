package com.ryanbrandt.jadux.models;

import java.util.ArrayList;

public final class ArrayData implements Data {
    private ArrayList<Object> value;

    public ArrayData(ArrayList<Object> value) {
        this.value = value;
    }

    public String getType() {
        return "Array";
    }

    public ArrayList<Object> getValue() {
        return this.value;
    }
}