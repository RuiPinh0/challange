package com.family.families.controller;

import com.family.families.model.Family;
import com.family.families.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FamilyController {

    @Autowired
    FamilyRepository familyRepository;

    @GetMapping("/family/{id}")
    public Family getFamily(@PathVariable(value = "id")Long id) throws Exception{
        return familyRepository.findById(id).orElseThrow(() -> new Exception("implement"));
    }
}
