package com.ryanbrandt.jadux.application;

import java.lang.Exception;

public final class UniqueActionException extends Exception {

    protected UniqueActionException() {
        super("Only one Action is permitted per ActionType");
    }
}