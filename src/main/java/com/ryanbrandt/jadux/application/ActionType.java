package com.ryanbrandt.jadux.application;

/**
 * Simple ActionType object, used to internally representing Jadux action types
 * which are associated with Actions
 * 
 * @author Ryan Brandt
 */
public class ActionType {
    private String type;

    protected ActionType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
