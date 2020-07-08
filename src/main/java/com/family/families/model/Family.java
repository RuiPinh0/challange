package com.family.families.model;

import com.family.families.exceptions.FamilyCannotBeDeleted;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String country;

    @OneToMany(mappedBy = "family", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Member> members = new ArrayList<>();

    @PreRemove
    private void preRemove() throws FamilyCannotBeDeleted {
        if(!members.isEmpty()){
            throw new FamilyCannotBeDeleted();
        }
    }

    public String toString(){
        return getId().toString();
    }
}
