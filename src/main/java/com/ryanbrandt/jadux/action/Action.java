package com.ryanbrandt.jadux.action;

import com.ryanbrandt.jadux.models.Payload;

/**
 * Actions represent how we want to update our applications Store. Actions point
 * to a registered ActionType via actionTypeRef and send data through a Payload
 * instance.
 * 
 * @author Ryan Brandt
 */
public final class Action {
    private String actionTypeRef;
    private Payload payload;

    /**
     * Instantiates a new Action with a payload
     * 
     * @param actionTypeRef The ActionType reference
     * @param payload       The Action payload
     */
    public Action(String actionTypeRef, Payload payload) {
        this.actionTypeRef = actionTypeRef;
        this.payload = payload;
    }

    /**
     * Instantiates an Action without a payload
     * 
     * @param actionTypeRef The ActionType reference
     */
    public Action(String actionTypeRef) {
        this(actionTypeRef, null);
    }

    /**
     * ActionType reference getter
     * 
     * @return The ActionType reference associated with the Action
     */
    public String getType() {
        return this.actionTypeRef;
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