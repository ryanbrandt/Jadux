package com.ryanbrandt.jadux.reducer;

import java.util.HashMap;
import java.util.Observable;

import com.ryanbrandt.jadux.action.Action;
import com.ryanbrandt.jadux.models.JaduxData;

/**
 * Master interface for reducers. Mandates a reduce method which takes an action
 * and applies it to state.
 * 
 * @author Ryan Brandt
 */
public abstract class Reducer extends Observable {

    /**
     * Defines how an action is applied to state.
     * 
     * @param a The Action to act on State
     */
    public abstract void reduce(Action<? extends JaduxData> a);

    /**
     * Commits changes specified in reduce to the store. Really just a wrapper to
     * hide some internals.
     * 
     * @param updatedState The changes in state specified through reduce
     */
    protected void commit(HashMap<String, JaduxData> updatedState) {
        notifyObservers(updatedState);
    }
}