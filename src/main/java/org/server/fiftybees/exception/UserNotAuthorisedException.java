package org.server.fiftybees.exception;

public class UserNotAuthorisedException extends RuntimeException {
    public UserNotAuthorisedException(String message) {
        super(message);
    }
}
