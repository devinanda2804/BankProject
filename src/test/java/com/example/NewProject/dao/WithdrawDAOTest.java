package com.example.NewProject.dao;

import com.example.NewProject.Domain.AccountDetails;
import lombok.With;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import static org.mockito.Mockito.verify;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class WithdrawDAOTest {

    @InjectMocks
    private WithdrawDAO withdrawDAO;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAccountTest(){
        int accountNo=90;
        AccountDetails accountDetails=new AccountDetails();
        accountDetails.setAccount_No(accountNo);

        when(entityManager.find(AccountDetails.class,accountNo)).thenReturn(accountDetails);

        AccountDetails result=withdrawDAO.findAccount(accountNo);

        assertNotNull(result);
        assertEquals(accountNo, result.getAccount_No());
        verify(entityManager, times(1)).find(AccountDetails.class, accountNo);
    }

    @Test
    public  void updateAccountTest(){
        int accountNo=90;
        AccountDetails accountDetails=new AccountDetails();
        accountDetails.setAccount_No(accountNo);
        when(entityManager.merge(accountDetails)).thenReturn(accountDetails);
        withdrawDAO.updateAccount(accountDetails);

        verify(entityManager).merge(accountDetails);
    }




}