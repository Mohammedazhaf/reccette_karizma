package com.example.reccette_karizma.Exception;


public class RecetteNotFoundException extends RuntimeException {

    public RecetteNotFoundException(String message) {
        super(message);
    }
}
