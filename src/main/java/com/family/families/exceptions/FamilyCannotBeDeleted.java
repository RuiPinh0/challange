package com.family.families.exceptions;

public class FamilyCannotBeDeleted extends Throwable {
    public FamilyCannotBeDeleted(){
        super("This family still have members associated");
    }
}
