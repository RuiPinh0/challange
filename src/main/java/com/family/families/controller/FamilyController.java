package com.family.families.controller;

import com.family.families.exceptions.FamilyCannotBeDeleted;
import com.family.families.exceptions.FamilyNotFoundException;
import com.family.families.exceptions.InvalidCountryException;
import com.family.families.model.Family;
import com.family.families.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @GetMapping("/{id}")
    public Family getFamily(@PathVariable(value = "id")Long id) throws FamilyNotFoundException{
        return familyService.getFamily(id);
    }

    @GetMapping()
    public List<Family> getAllFamilies(){
        return familyService.getAllFamilies();
    }

    @GetMapping("/country/{ctr}")
    public List<Family> getAllFamilies(@PathVariable(value = "ctr")String countryCode) throws InvalidCountryException{
        return familyService.getFamiliesByCountryCode(countryCode);
    }

    @PostMapping
    public Family createFamily(@RequestBody Family family) throws InvalidCountryException {
        return familyService.createFamily(family);
    }

    @DeleteMapping("/{id}")
    public void deleteFamily(@PathVariable(value = "id")Long id) throws FamilyNotFoundException, FamilyCannotBeDeleted {
        familyService.deleteFamily(id);
    }

    @PutMapping
    public void updateFamily(@RequestBody @Valid Family family)  {
        familyService.updateFamily(family);
    }

    @PatchMapping
    public Family patchFamily(@RequestBody @Valid Family family) throws InvalidCountryException {
        return familyService.patchFamily(family);
    }
}
