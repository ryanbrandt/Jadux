package com.ryanbrandt.jadux.application;

import com.ryanbrandt.jadux.models.Payload;

/**
 * Actions represent how we want to update our applications Store. Actions point
 * to a registered ActionType via actionType and send data through a Payload
 * instance.
 * 
 * @author Ryan Brandt
 */
public class Action {
    private String actionType;
    private Payload payload;

    /**
     * Instantiates a new Action with a payload
     * 
     * @param actionTypeRef The action type (e.g. MY_ACTION)
     * @param payload       The Action payload
     */
    protected Action(String actionType, Payload payload) {
        this.actionType = actionType;
        this.payload = payload;
    }

    /**
     * Instantiates an Action without a payload
     * 
     * @param actionTypeRef The ActionType reference
     */
    public Action(String actionType) {
        this(actionType, null);
    }

    /**
     * ActionType instance getter
     * 
     * @return The action type of the Action
     */
    public String getType() {
        return this.actionType;
    }

    /**
     * Action payload getter
     * 
     * @return The Action payload
     */
    public Payload getPayload() {
        return this.payload;
    }

}