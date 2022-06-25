package com.proyecto.proyecto.excepciones;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(final String message){
        super(message);
    }
}
