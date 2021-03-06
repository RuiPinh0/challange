package com.family.families.model;

import com.family.families.exceptions.MemberCannotBeDeletedException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Family.class)
    @JoinColumn(name = "family_id", insertable = false, updatable = false)
    @JsonIgnore
    private Family family;

    @Column(name="family_id")
    private Long familyId;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @ManyToOne(optional=true, fetch=FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "father_id", insertable = false, updatable = false)
    @JsonIgnore
    private Member father;

    @Column(name="father_id")
    private Long fatherId;

    @ManyToOne(optional=true, fetch=FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "mother_id", insertable = false, updatable = false)
    @JsonIgnore
    private Member mother;

    @Column(name="mother_id")
    private Long motherId;

    @OneToOne(targetEntity = Member.class)
    @JoinColumn(name = "spouse_id", insertable = false, updatable = false)
    @JsonIgnore
    private Member spouse;

    @Column(name="spouse_id")
    private Long spouseId;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/London")
    @Column(name="birth_date")
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "father")
    @JsonIgnore
    private List<Member> fatherChild;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="mother")
    @JsonIgnore
    private List<Member> motherChild;

    @PreRemove
    private void preRemove() throws MemberCannotBeDeletedException {
        if(!fatherChild.isEmpty() || !motherChild.isEmpty()){
            throw new MemberCannotBeDeletedException();
        }
    }
}
