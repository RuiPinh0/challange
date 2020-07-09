package com.family.families.exceptions;

public class MemberCannotBeDeletedException extends RuntimeException {
        public MemberCannotBeDeletedException(){
            super("This member have children associated");
        }
}
