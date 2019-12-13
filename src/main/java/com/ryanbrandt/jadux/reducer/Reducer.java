package com.ryanbrandt.jadux.reducer;

import java.util.HashMap;

import com.ryanbrandt.jadux.action.Action;
import com.ryanbrandt.jadux.models.JaduxData;

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
    public HashMap<String, JaduxData> reduce(Action<? extends JaduxData> a, HashMap<String, JaduxData> state);
}