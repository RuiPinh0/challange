package com.family.families.service;

import com.family.families.model.Family;

import java.util.List;

public interface FamilyService {

    List<Family> getAllFamilies();

    Family getFamily(Long id);

    List<Family> getFamiliesByCountryCode(String countryCode);

    Family createFamily(Family family);

    void updateFamily(Family family);

    Family patchFamily(Family family);

    void deleteFamily(Long id);
}
