package com.ryanbrandt.jadux.action;

import com.ryanbrandt.jadux.models.Payload;

/**
 * Actions represent how we want to update our applications Store
 * 
 * @author Ryan Brandt
 */
public final class Action {
    private ActionType type;
    private Payload payload;

    /**
     * Dispatch sends an action to our reducers to update our applications Store
     * 
     * @param a The Action instance for our reducer to interpret
     */
    public static void Dispatch(Action a) {

    }

    /**
     * Instantiates a new Action with a payload
     * 
     * @param type    The Action type
     * @param payload The Action payload
     */
    public Action(ActionType type, Payload payload) {
        this.type = type;
        this.payload = payload;
    }

    /**
     * Instantiates an Action without a payload
     * 
     * @param type The Action type
     */
    public Action(ActionType type) {
        this(type, null);
    }

    /**
     * Action type getter
     * 
     * @return The Action type
     */
    public ActionType getType() {
        return this.type;
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