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
    private static HashMap<String, ActionType> actionTypes = new HashMap<>();
    private static HashMap<ActionType, Action> actions = new HashMap<>();
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
     * Registers a new application ActionType. Simple method to allow users to
     * register new ActionTypes (e.g. Redux's const ACTION_TYPE = "ACTION_TYPE") in
     * a simple method, rather than a definition file
     * 
     * @param actionTypeReference The reference (name) of the ActionType to be added
     * @throws UniqueActionTypeReferenceException When a duplicate ActionType is
     *                                            attempted to be defined
     *
     */
    public static void registerActionType(String actionTypeReference) throws UniqueActionTypeReferenceException {
        if (Jadux.actionTypes.containsKey(actionTypeReference)) {
            throw new UniqueActionTypeReferenceException();
        }

        Jadux.actionTypes.put(actionTypeReference, new ActionType(actionTypeReference));
        System.out.println(Jadux.actionTypes);
    }

    /**
     * Registers a new application Action, which users can then instantiate with
     * getApplicationAction() for Dispatch.send()
     * 
     * @param actionType The name of the ActionType the Action is to be associated
     *                   with
     * @param payload    The Payload object to be sent with the Action
     * @throws UniqueActionException           If Action to be registered is not
     *                                         unique (an Action is already
     *                                         associated with this ActionType)
     * @throws ActionTypeDoesNotExistException If ActionType to be associated with
     *                                         does not exist
     */
    public static void registerAction(String actionType, Payload payload)
            throws UniqueActionException, ActionTypeDoesNotExistException {
        final ActionType associatedActionType = getActionType(actionType);
        if (Jadux.actions.containsKey(associatedActionType)) {
            throw new UniqueActionException();
        }

        Jadux.actions.put(associatedActionType, new Action(associatedActionType, payload));
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
    public static void registerAction(String actionType) throws UniqueActionException, ActionTypeDoesNotExistException {
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
    public static Action getApplicationAction(String actionType)
            throws ActionTypeDoesNotExistException, ActionDoesNotExistException {
        final ActionType associatedActionType = getActionType(actionType);
        if (!Jadux.actions.containsKey(associatedActionType)) {
            throw new ActionDoesNotExistException();
        }

        return Jadux.actions.get(associatedActionType);
    }

    /**
     * JADUX INTERNAL
     */

    private static ActionType getActionType(String actionType) throws ActionTypeDoesNotExistException {
        if (!Jadux.actionTypes.containsKey(actionType)) {
            for (String s : Jadux.actionTypes.keySet()) {
                System.out.println(Jadux.actionTypes.get(s));
            }
            System.out.println("FOO");
            System.out.println(Jadux.actionTypes);
            throw new ActionTypeDoesNotExistException();
        }

        return Jadux.actionTypes.get(actionType);
    }
}