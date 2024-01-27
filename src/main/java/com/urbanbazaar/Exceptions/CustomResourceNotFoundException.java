package com.urbanbazaar.Exceptions;

public class CustomResourceNotFoundException extends RuntimeException{
    public CustomResourceNotFoundException(String message) {
        super(message);
    }
}
