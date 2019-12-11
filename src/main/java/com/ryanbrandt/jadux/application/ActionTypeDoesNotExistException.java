package com.ryanbrandt.jadux.application;

import java.lang.Exception;

public final class ActionTypeDoesNotExistException extends Exception {

    protected ActionTypeDoesNotExistException() {
        super("ActionType referenced is not registered with your application");
    }
}