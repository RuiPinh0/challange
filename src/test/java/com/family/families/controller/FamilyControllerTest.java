package com.family.families.controller;

import com.family.families.repository.FamilyRepository;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URISyntaxException;

@SpringBootTest(
        webEnvironment=SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class FamilyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private FamilyRepository familyRepository;

    @Test
    public void testGetEmployeeListSuccess() throws URISyntaxException
    {

      /*  mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("bob")));*/

    }

}
