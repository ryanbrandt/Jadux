package com.ryanbrandt.jadux.application;

import java.lang.Exception;

public final class InvalidReducerReferenceException extends Exception {

    protected InvalidReducerReferenceException() {
        super("Invalid Reducer reference provided");
    }
}