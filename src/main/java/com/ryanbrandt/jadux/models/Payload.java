package com.ryanbrandt.jadux.models;

/**
 * Model defining an Action payload. Contains a generic Jadux Data object.
 * 
 * @author Ryan Brandt
 */
public final class Payload {
    private Data data;

    /**
     * Jadux Data object getter
     * 
     * @return Data object associated with payload
     */
    public Data getData() {
        return this.data;
    }
}