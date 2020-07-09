package com.family.families.service;

import com.family.families.exceptions.FamilyNotFoundException;
import com.family.families.exceptions.InvalidCountryException;
import com.family.families.model.Family;
import com.family.families.repository.FamilyRepository;
import com.family.families.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService{

    @Autowired
    FamilyRepository familyRepository;


    @Override
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    @Override
    public Family getFamily(Long id) {
       return familyRepository.findById(id).orElseThrow(() -> new FamilyNotFoundException(id));
    }

    @Override
    public List<Family> getFamiliesByCountryCode(String countryCode) {
        if (Utils.validateIsoCountry2(countryCode)){
            return familyRepository.findByCountry(countryCode);
        }else{
            throw new InvalidCountryException(countryCode);
        }
    }

    @Override
    public Family   createFamily(Family family) {
        if (Utils.validateIsoCountry2(family.getCountry())){
            return familyRepository.save(family); }
        else{
            throw new InvalidCountryException(family.getCountry());
        }
    }

    @Override
    public void updateFamily(Family family) {
        if (Utils.validateIsoCountry2(family.getCountry())){
            familyRepository.save(family); }
        else{
            throw new InvalidCountryException(family.getCountry());
        }
    }

    @Override
    public Family patchFamily(Family family) {
        Family familyAux = familyRepository.findById(family.getId()).orElseThrow(
                () -> new FamilyNotFoundException(family.getId()));

        if (!familyAux.getCountry().equals(family.getCountry())){
            if (Utils.validateIsoCountry2(family.getCountry())){
                familyAux.setCountry(family.getCountry());
            }else{
                throw new InvalidCountryException(family.getCountry());
            }
        }
        if (!familyAux.getName().equals(family.getName())){
            familyAux.setName(family.getName());
        }

        return familyRepository.save(familyAux);
    }

    @Override
    public void deleteFamily(Long id) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new FamilyNotFoundException(id));
        familyRepository.delete(family);
    }
}
