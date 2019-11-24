package com.ryanbrandt.jadux.application;

import java.lang.Exception;

public final class StoreAlreadyExistsException extends Exception {

    protected StoreAlreadyExistsException() {
        super("A store already exists for this application");
    }
}