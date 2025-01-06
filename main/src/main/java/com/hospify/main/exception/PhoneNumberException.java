package com.hospify.main.exception;

public class PhoneNumberException extends Exception{

    public PhoneNumberException() {
        super();
    }

    public PhoneNumberException(String message) {
        super(message);
    }

    public PhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneNumberException(Throwable cause) {
        super(cause);
    }
}
