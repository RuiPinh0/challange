package com.family.families.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class Utils {

    public static Boolean validateIsoCountry2(String iso2){

        Set<String> isoCountries = new HashSet<String>(Arrays.asList(Locale.getISOCountries()));

        return isoCountries.contains(iso2);
    }
}
