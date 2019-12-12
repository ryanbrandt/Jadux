package com.ryanbrandt.jadux.application;

import java.util.HashMap;

import com.ryanbrandt.jadux.reducer.Reducer;
import com.ryanbrandt.jadux.models.Payload;

/**
 * Jadux global, maintains a singleton Store and Maps of application Reducers,
 * ActionTypes and Actions. Static references only.
 * 
 * @author Ryan Brandt
 */
public final class Jadux {
    private static Store store;
    private static HashMap<String, Action> actions = new HashMap<>();
    private static HashMap<String, Reducer> reducers = new HashMap<>();

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
     * USER SETTERS
     */

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
     * Registers a new application Action, which users can then instantiate with
     * getApplicationAction() for Dispatch.send()
     * 
     * @param actionType The name/type of the Action to be registered
     * @param payload    The Payload object to be sent with the Action
     * @throws UniqueActionException If an Action already exists with the same
     *                               name/type
     */
    public static void registerAction(String actionType, Payload payload) throws UniqueActionException {
        if (Jadux.actions.containsKey(actionType)) {
            throw new UniqueActionException();
        }

        Jadux.actions.put(actionType, new Action(actionType, payload));
    }

    /**
     * Registers a new application Action, which users can then instantiate with
     * getApplicationAction() for Dispatch.send()
     * 
     * @param actionType The name of the ActionType the Action is to be associated
     *                   with
     * @throws UniqueActionException           If Action to be registered is not
     *                                         unique (an Action is already
     *                                         associated with this ActionType)
     * @throws ActionTypeDoesNotExistException If ActionType to be associated with
     *                                         does not exist
     */
    public static void registerAction(String actionType) throws UniqueActionException {
        registerAction(actionType, null);
    }

    /**
     * USER GETTERS
     */

    /**
     * Grabs a user registered Action so a user can dispatch an action (e.g.
     * Dispatch.send(getApplicationAction("MY_ACTION")))
     * 
     * @param actionType The name of the associated ActionType
     * @throws ActionTypeDoesNotExistException If the associated ActionType does not
     *                                         exist
     * @throws ActionDoesNotExistException     If the associated ActionType exists,
     *                                         but no Action has been registered
     *                                         with it
     * @return The Action instance associated with the ActionType
     */
    public static Action getApplicationAction(String actionType) throws ActionDoesNotExistException {
        if (!Jadux.actions.containsKey(actionType)) {
            throw new ActionDoesNotExistException();
        }

        return Jadux.actions.get(actionType);
    }
}