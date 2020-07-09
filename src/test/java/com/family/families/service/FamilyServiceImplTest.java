package com.family.families.service;

import com.family.families.model.Family;
import com.family.families.repository.FamilyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class FamilyServiceImplTest {

    @TestConfiguration
    static class FamilyServiceImplTestContextConfiguration {

        @Bean
        public FamilyService familyService() {
            return new FamilyServiceImpl();
        }
    }

    @Autowired
    private FamilyService familyService;

    @MockBean
    private FamilyRepository familyRepository;

    @Before
    public void setup(){

        Family family = new Family();
        family.setId(1L);
        family.setCountry("PT");
        family.setName("Santos");

        Family family1 = new Family();
        family1.setId(2L);
        family1.setCountry("EN");
        family1.setName("Ferdinand");

        List<Family> allFamilies = new ArrayList<>();
        allFamilies.add(family);
        allFamilies.add(family1);

        Mockito.when(familyRepository.findById(family.getId()))
                .thenReturn(Optional.of(family));
        Mockito.when(familyRepository.findByCountry(family.getCountry()))
                .thenReturn(Collections.singletonList(family));
        Mockito.when(familyRepository.save(family)).thenReturn(family);
        Mockito.when(familyRepository.findAll())
        .thenReturn(allFamilies);
    }

    @Test
    public void getAllFamiliesTest(){
        assertThat(familyRepository.findAll().size()).isEqualTo(2);
        assertThat(familyRepository.findAll()).isNotEmpty();
    }

    @Test
    public void getFamilyByIdTest(){
        assertThat(familyRepository.findById(1L)).isPresent();
        assertThat(familyRepository.findById(3L)).isEmpty();
    }
}
