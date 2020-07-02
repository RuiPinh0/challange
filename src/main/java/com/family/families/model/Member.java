package com.family.families.model;

import lombok.*;
import java.util.Date;

@Getter @Setter
public class Member {

    Family family;
    String firstName;
    String middleName;
    Member father;
    Member mother;
    Member spouse;
    Date birthDate;


}
