package com.example.NewProject.dao;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.Person;
import com.example.NewProject.dao.PersonDetailsDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;

public class PersonDetailsDAOTest {

    @InjectMocks
    private PersonDetailsDAO personDetailsDAO;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveAccount() {

        AccountDetails account = new AccountDetails();
        account.setAccount_Balance(1000);

        personDetailsDAO.saveAccount(account);

        verify(entityManager, times(1)).persist(account);
    }

    @Test
    public void testSavePerson() {
        Person person = new Person();
        person.setName("John Doe");

        personDetailsDAO.savePerson(person);

        verify(entityManager, times(1)).persist(person);
    }
}
