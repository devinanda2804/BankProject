package com.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.Person;
import com.example.NewProject.Services.PersonDetailsService;
import com.example.NewProject.dao.PersonDetailsDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

public class PersonDetailsServiceTest {

    @InjectMocks
    private PersonDetailsService personDetailsService;

    @Mock
    private PersonDetailsDAO personDetailsDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPersonDetailSavesData() throws Exception {

        Person person = new Person();
        person.setName("John Doe");
        person.setDob("2002-10-18");




        personDetailsService.PersonDetail(person);

        verify(personDetailsDAO, times(1)).savePerson(person);


        assertThat(person.getName()).isEqualTo("John Doe");
        assertThat(person.getDob()).isEqualTo("2002-10-18");
    }
}


