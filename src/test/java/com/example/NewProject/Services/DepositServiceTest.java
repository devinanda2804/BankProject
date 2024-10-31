package com.example.NewProject.Services;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.dao.AccountDAO;
import com.example.NewProject.dao.TransactionDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepositServiceTest {


    @InjectMocks
    private DepositService depositService;

    @Mock
    private TransactionDAO transactionDAO;

    @Mock
    private  AccountDAO accountDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void setDepositService(){
        int accountNo=1234;
        int amount=700;

        when(accountDAO.depositAmount(accountNo,amount)).thenReturn(true);


        boolean message=depositService.deposit(accountNo,amount);

        assertTrue(message);
        verify(accountDAO,times(1)).depositAmount(accountNo,amount);

    }

}