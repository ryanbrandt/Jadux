package com.ryanbrandt.jadux.reducer;

import com.ryanbrandt.jadux.action.Action;

/**
 * Master interface for reducers. Mandates a reduce method which takes an action
 * and applies it to state.
 * 
 * @author Ryan Brandt
 */
public interface Reducer {

    /**
     * Defines how an action is applied to state.
     * 
     * @param a The Action to act on State
     */
    public void reduce(Action a);
}