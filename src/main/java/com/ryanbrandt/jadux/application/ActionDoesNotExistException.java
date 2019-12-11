package com.ryanbrandt.jadux.application;

import java.lang.Exception;

public final class ActionDoesNotExistException extends Exception {

    protected ActionDoesNotExistException() {
        super("Action requested is not registered with your application");
    }
}