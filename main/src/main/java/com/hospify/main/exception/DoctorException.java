package com.hospify.main.exception;

public class DoctorException extends Exception{
    public DoctorException() {
        super();
    }

    public DoctorException(String message) {
        super(message);
    }

    public DoctorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorException(Throwable cause) {
        super(cause);
    }
}
