package com.family.families.exceptions;

public class NoResultFoundException extends RuntimeException {

    public NoResultFoundException(){
        super("No results found for this service request");
    }
}
