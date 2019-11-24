package com.ryanbrandt.jadux.application;

import java.lang.Exception;

public final class UniqueReducerReferenceException extends Exception {

    protected UniqueReducerReferenceException() {
        super("Reducer references must be unique");
    }
}