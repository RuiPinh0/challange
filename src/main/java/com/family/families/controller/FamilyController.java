package com.family.families.controller;

import com.family.families.exceptions.FamilyNotFoundException;
import com.family.families.model.Family;
import com.family.families.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @GetMapping("/family/{id}")
    public Family getFamily(@PathVariable(value = "id")Long id) throws FamilyNotFoundException{
        return familyService.getFamily(id);
    }

    @PostMapping("/family")
    public void createFamily(Family family){

    }
}
