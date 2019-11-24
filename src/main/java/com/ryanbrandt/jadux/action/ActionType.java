package com.ryanbrandt.jadux.action;

public class ActionType {
    private String type;
    private String reducerRef;

    public ActionType(String type, String reducerRef) {
        this.type = type;
        this.reducerRef = reducerRef;
    }

    public String getType() {
        return this.type;
    }

    public String getReducerRef() {
        return this.reducerRef;
    }

}