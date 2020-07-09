package com.family.families.repository;

import com.family.families.model.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FamilyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FamilyRepository familyRepository;

    @Test
    public void findByNa_ReturnFamily(){
        Family santos = new Family();
        santos.setCountry("PT");
        santos.setName("Santos");

    }
}
