package com.family.families.exceptions;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long id){
        super(String.format("Family Member with the id {} was not found!", id));
    }
}
