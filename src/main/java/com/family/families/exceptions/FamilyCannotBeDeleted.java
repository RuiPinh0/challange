package com.family.families.exceptions;

public class FamilyCannotBeDeleted extends RuntimeException {
    public FamilyCannotBeDeleted(){
        super("This family still have members associated");
    }
}
