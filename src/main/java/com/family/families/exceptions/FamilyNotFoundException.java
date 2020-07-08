package com.family.families.exceptions;

public class FamilyNotFoundException extends RuntimeException{

    public FamilyNotFoundException(Long id){
        super(String.format("Family with the id {} was not found!", id));
    }
}
