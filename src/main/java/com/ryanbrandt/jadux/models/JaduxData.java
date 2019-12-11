package com.ryanbrandt.jadux.models;

/**
 * Master interface defining all Jadux Data objects. Custom Data objects must
 * implement this interface.
 * 
 * @author Ryan Brandt
 */
public interface JaduxData {

    /**
     * Data object value type getter
     * 
     * @return The type of the value associated with the Data object
     */
    public String getType();

    /**
     * Data object value getter
     * 
     * @return The value, of the type returned in getType(), associated with the
     *         Data object
     */
    public Object getValue();
}