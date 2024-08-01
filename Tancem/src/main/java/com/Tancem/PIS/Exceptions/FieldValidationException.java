package com.Tancem.PIS.Exceptions;

public class FieldValidationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public FieldValidationException(String message) {
        super(message);
    }
}
