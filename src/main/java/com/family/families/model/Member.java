package com.family.families.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank
    Long familyId;
    @NotBlank
    String firstName;
    @NotBlank
    String middleName;
    @NotBlank
    Long fatherId;
    @NotBlank
    Long motherId;
    Long spouseId;
    @NotBlank
    Date birthDate;


}
