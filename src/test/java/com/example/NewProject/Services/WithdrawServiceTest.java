package com.example.NewProject.Services;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.dao.WithdrawDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static javafx.beans.binding.Bindings.when;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
class WithdrawServiceTest {

    @InjectMocks
    private WithdrawService withdrawService;

    @Mock
    private WithdrawDAO withdrawDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testWithdrawBalanceTooLow() {
        int accountNo = 90;
        int amount = 100;

        AccountDetails mockAccount = new AccountDetails();
        mockAccount.setAccount_Balance(0);
        mockAccount.setAccount_No(accountNo);

        when(withdrawDAO.findAccount(accountNo)).thenReturn(mockAccount);


        assertThrows(IllegalArgumentException.class, () -> {
            withdrawService.withdraw(accountNo, amount);
        });


        verify(withdrawDAO, times(1)).findAccount(accountNo);

        verify(withdrawDAO, never()).updateAccount(mockAccount);
        verify(withdrawDAO, never()).saveTransaction(any(TransactionDetails.class));
    }

    @Test
    public void testBalanceSuccess(){
        int accountNo=90;
        int amount=100;

        AccountDetails accountDetails=new AccountDetails();
        accountDetails.setAccount_No(accountNo);
        accountDetails.setAccount_Balance(1000);

        when(withdrawDAO.findAccount(accountNo)).thenReturn(accountDetails);

       boolean message=withdrawService.withdraw(accountNo,amount);

       assertTrue(message);
       verify(withdrawDAO,times(1)).updateAccount(accountDetails);
       verify(withdrawDAO,times(1)).saveTransaction(any(TransactionDetails.class));

    }
}
