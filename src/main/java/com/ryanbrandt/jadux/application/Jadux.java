package com.ryanbrandt.jadux.application;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import com.ryanbrandt.jadux.reducer.Reducer;
import com.ryanbrandt.jadux.action.Action;
import com.ryanbrandt.jadux.models.JaduxData;

/**
 * Jadux global, maintains a singleton Store and Maps of application Reducers,
 * ActionTypes and Actions. Static references only.
 * 
 * @author Ryan Brandt
 */
public final class Jadux implements Observer {
    private static Store store;
    private static HashMap<String, Action<? extends JaduxData>> actions = new HashMap<>();
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

    /*****************************
     * USER SETTERS
     ****************************/

    /**
     * Registers a new application Reducer
     * 
     * @param reducer The Reducer added to the application
     */
    public static void registerReducer(Reducer reducer) {
        Jadux.reducers.put(reducer.getClass().getName(), reducer);
    }

    /**
     * Registers a new application Action, which users can then instantiate with
     * getApplicationAction() for Dispatch.send()
     * 
     * @param action The new Action to be registered with the application
     * @throws UniqueActionException If an Action already exists with the same
     *                               actionType
     */
    public static void registerAction(Action<?> action) throws UniqueActionException {
        if (Jadux.actions.containsKey(action.getType())) {
            throw new UniqueActionException();
        }

        Jadux.actions.put(action.getType(), action);
    }

    /*****************************
     * USER GETTERS
     ****************************/

    /**
     * Grabs a user registered Action so a user can dispatch an action (e.g.
     * Dispatch.send(getApplicationAction("MY_ACTION")))
     * 
     * @param actionType The name of the associated ActionType
     * @throws ActionDoesNotExistException If no action exists under the requested
     *                                     actionType
     * @return The Action instance associated with the actionType
     */
    public static Action<? extends JaduxData> getApplicationAction(String actionType)
            throws ActionDoesNotExistException {
        if (!Jadux.actions.containsKey(actionType)) {
            throw new ActionDoesNotExistException();
        }

        return Jadux.actions.get(actionType);
    }

    /*****************************
     * REDUCER OBSERVATION
     ****************************/

    @SuppressWarnings("unchecked")
    public void update(Observable obj, Object arg) {
        HashMap<String, JaduxData> updatedState = (HashMap<String, JaduxData>) arg;
        Jadux.store.updateState(updatedState);
    }

    /*****************************
     * DEBUGGING UTILITIES
     ****************************/

    /**
     * Returns # of registered Reducers. Debugging tool.
     * 
     * @return The number of application registered Reducers
     */
    public static int getNumReducers() {
        return Jadux.reducers.size();
    }

    /**
     * Returns the # of registered Actions. Debugging tool.
     * 
     * @return The number of application registered Actions
     */
    public static int getNumActions() {
        return Jadux.actions.size();
    }
}