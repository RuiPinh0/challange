package com.family.families.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    Family family;

    @NotNull
    String firstName;

    @NotNull
    String middleName;

    @OneToOne
    Member father;

    @OneToOne
    Member mother;

    @OneToOne
    Member spouse;

    @NotNull
    Date birthDate;


}
