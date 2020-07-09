package com.family.families.exceptions;

public class FamilyCannotBeDeletedException extends RuntimeException {
    public FamilyCannotBeDeletedException(){
        super("This family still have members associated");
    }
}
