package com.family.families.exceptions;

public class IsParentException extends RuntimeException {
    public IsParentException(){
        super("This member can't be deleted because is a family parent");
    }
}
