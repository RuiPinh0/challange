package com.family.families.service;

import com.family.families.exceptions.FamilyNotFoundException;
import com.family.families.model.Family;
import com.family.families.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl  implements FamilyService{

    @Autowired
    FamilyRepository familyRepository;


    @Override
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    public Family getFamily(Long id) {
       return familyRepository.findById(id).orElseThrow(() -> new FamilyNotFoundException(id));
    }

    @Override
    public List<Family> getFamiliesByCountryCode(String countryCode) {
        return familyRepository.findByCountry(countryCode);
    }

    @Override
    public Family getFamilyWithHigherAccumulatedAge() {
       // familyRepository.findBy
        return null;
    }

    @Override
    public Family getFamilyWithHigherGrowingRate() {
        return null;
    }

    @Override
    public void createFamily(Family family) {

        familyRepository.save(family);
    }

    @Override
    public void updateFamily(Family family) {

    }

    @Override
    public void deleteFamily(Family family) {

    }
}
