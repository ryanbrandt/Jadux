package com.ryanbrandt.jadux.action;

import com.ryanbrandt.jadux.models.JaduxData;

/**
 * Actions represent how we want to update our applications Store. Actions point
 * to a registered ActionType via actionType and send data through a Payload
 * instance.
 * 
 * @author Ryan Brandt
 */
public class Action<T extends JaduxData> {
    private String actionType;
    private T payload;

    /**
     * Instantiates a new Action
     * 
     * @param actionTypeRef The action type (e.g. MY_ACTION)
     */
    public Action(String actionType) {
        this.actionType = actionType;
    }

    /**
     * Sets the payload for the Action
     * 
     * @param value The value the payload is to be set to
     */
    public void setPayload(JaduxData value) throws IllegalArgumentException {
        try {
            final T parameterizedValue = (T) value;
            this.payload = parameterizedValue;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Payload provided does not match Action parameterized type");
        }

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
    public T getPayload() {
        return this.payload;
    }

}