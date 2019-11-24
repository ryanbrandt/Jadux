package com.ryanbrandt.jadux.application;

import java.lang.Exception;

public final class UniqueActionTypeReferenceException extends Exception {

    protected UniqueActionTypeReferenceException() {
        super("Application ActionTypes must be unique");
    }
}