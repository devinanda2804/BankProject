package com.demo.repo;

/*
import com.example.NewProject.Domain.TestAccountDetails;  // Use the test entity
import com.example.NewProject.NewProjectApplication;
import com.example.NewProject.dao.DeleteAccountDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest(classes = NewProjectApplication.class)
@ActiveProfiles("test")
public class DeleteTest {

    @Autowired
    private DeleteAccountDAO deleteAccountDAO;

    @Test
    @Transactional
    public void testDelete() {

        TestAccountDetails accountDetails = new TestAccountDetails();
        accountDetails.setAccountBalance(1200);
     */
/*   accountDetails.setAccountNo(67);*//*

        accountDetails.setDateTime(LocalDateTime.now());


        deleteAccountDAO.saveAccount(accountDetails);  // Ensure this method uses TestAccountDetails


        TestAccountDetails accountDetailsFound = deleteAccountDAO.find(67); // Use the correct accountNo
        Assertions.assertThat(accountDetailsFound).isNotNull();


        deleteAccountDAO.removeAccnt(accountDetailsFound);


        TestAccountDetails accountDetailsAfterDelete = deleteAccountDAO.find(67);
        Assertions.assertThat(accountDetailsAfterDelete).isNull();
    }
}
*/


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TestAccountDetails;
import com.example.NewProject.dao.DeleteAccountDAO;
import com.example.NewProject.Services.DeleteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DeleteTest {

    @InjectMocks
    private DeleteService deleteService;

    @Mock
    private DeleteAccountDAO deleteAccountDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteAccountSuccess() {

        Integer accountNo = 12345;
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccount_Balance(500);

        when(deleteAccountDAO.findAccount(accountNo)).thenReturn(accountDetails);
        doNothing().when(deleteAccountDAO).removeAccount(accountDetails);
        boolean result = deleteService.deleteAccnt(accountNo);


        assertTrue(result);
        verify(deleteAccountDAO, times(1)).removeAccount(accountDetails);
    }

    @Test
    public void testDeleteAccountBalanceTooHigh() {

        Integer accountNo = 12345;
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccount_Balance(600);

        when(deleteAccountDAO.findAccount(accountNo)).thenReturn(accountDetails);
        try {
            deleteService.deleteAccnt(accountNo);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {

            assertEquals("Balance is 600. Please withdraw before closing.", e.getMessage());
        }

    }

    @Test
    public void testDeleteAccountBalanceTooLow() {

        Integer accountNo = 12345;
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccount_Balance(300);

        when(deleteAccountDAO.findAccount(accountNo)).thenReturn(accountDetails);

        try{
            deleteService.deleteAccnt(accountNo);
            fail("Expected IllegalArgumentException to be thrown");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Balance is less than the minimum requirement. Unable to close.", e.getMessage());
        }
    }

    @Test
    public void testDeleteAccountDoesNotExist() {

        Integer accountNo = 12345;

        when(deleteAccountDAO.findAccount(accountNo)).thenReturn(null);

        try{
            deleteService.deleteAccnt(accountNo);
            fail("Expected IllegalArgumentException to be thrown");
        }
        catch (IllegalArgumentException e){

        assertEquals("Account number does not exist.", e.getMessage());
    }}
}
