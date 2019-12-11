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
    private ActionType actionType;
    private Payload payload;

    /**
     * Instantiates a new Action with a payload
     * 
     * @param actionTypeRef The ActionType reference
     * @param payload       The Action payload
     */
    protected Action(ActionType actionType, Payload payload) {
        this.actionType = actionType;
        this.payload = payload;
    }

    /**
     * Instantiates an Action without a payload
     * 
     * @param actionTypeRef The ActionType reference
     */
    public Action(ActionType actionType) {
        this(actionType, null);
    }

    /**
     * ActionType instance getter
     * 
     * @return The ActionType reference associated with the Action
     */
    public ActionType getType() {
        return this.actionType;
    }

    /**
     * ActionType.type getter, predominately for usage in Reducers
     * 
     * @return The ActionType.type associated with the Action
     */
    public String getTypeName() {
        return this.actionType.getType();
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