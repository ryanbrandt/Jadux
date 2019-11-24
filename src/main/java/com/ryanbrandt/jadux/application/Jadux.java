package com.ryanbrandt.jadux.application;

import java.util.HashMap;

import com.ryanbrandt.jadux.reducer.Reducer;
import com.ryanbrandt.jadux.action.ActionType;

/**
 * Jadux global, maintains a singleton Store and ArrayList of application
 * Reducers. Static references only.
 * 
 * @author Ryan Brandt
 */
public final class Jadux {
    private static Store store;
    private static HashMap<String, ActionType> actionTypes;
    private static HashMap<String, Reducer> reducers;

    private Jadux() {
    }

    /**
     * Creates a new Store instance for the application. Only one store is permitted
     * per application.
     * 
     * @throws StoreAlreadyExistsException When createStore is called more than once
     *                                     during runtime
     */
    public static void createStore() throws StoreAlreadyExistsException {
        if (Jadux.store != null) {
            throw new StoreAlreadyExistsException();
        }

        Jadux.store = new Store();
    }

    /**
     * Registers a new application Reducer, referable via reducerRef. All
     * reducerRefs must be unique.
     * 
     * @param reducerRef A string reference to the added Reducer. Must be unique.
     * @param reducer    The Reducer added to the application
     * @throws UniqueReducerReferenceException When a duplicate reducerRef is
     *                                         provided
     */
    public static void registerReducer(String reducerRef, Reducer reducer) throws UniqueReducerReferenceException {
        if (Jadux.reducers.containsKey(reducerRef)) {
            throw new UniqueReducerReferenceException();
        }

        Jadux.reducers.put(reducerRef, reducer);
    }

    /**
     * Registers a new application ActionType referable via actionTypeRef. All
     * actionTypeRefs must be unique.
     * 
     * @param actionTypeRef A string reference to the added ActionType. Must be
     *                      unique.
     * @param actionType    The ActionType added to the application
     * @throws InvalidReducerReferenceException   When an invalid reducerRef is
     *                                            provided on actionType
     * @throws UniqueActionTypeReferenceException When a duplicate ActionType
     *                                            reference is provided
     */
    public static void registerActionType(String actionTypeRef, ActionType actionType)
            throws InvalidReducerReferenceException, UniqueActionTypeReferenceException {
        if (Jadux.actionTypes.containsKey(actionTypeRef)) {
            throw new UniqueActionTypeReferenceException();
        }

        if (!Jadux.reducers.containsKey(actionType.getReducerRef())) {
            throw new InvalidReducerReferenceException();
        }

        Jadux.actionTypes.put(actionTypeRef, actionType);
    }
}