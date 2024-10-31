package com.example.NewProject.Services;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.dao.WithdrawDAO;
import javafx.beans.value.ObservableBooleanValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class WithdrawService {

    @Autowired
    private WithdrawDAO withdrawDAO;


    @Transactional
    public Boolean withdraw(int accountNo, int amount) {
       AccountDetails account=withdrawDAO.findAccount(accountNo);
        if (account == null) {
            throw new IllegalArgumentException("Account number does not exist");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        if (account.getAccount_Balance() < 500) {
            throw new IllegalArgumentException("Withdrawal failed. The current balance is not greater than or equal to 500.");
        }

        if (account.getAccount_Balance() - amount < 500) {
            throw new IllegalArgumentException("Withdrawal failed. The balance after withdrawal must not be less than 500.");
        }
        account.setAccount_Balance(account.getAccount_Balance()-amount);
        withdrawDAO.updateAccount(account);

        TransactionDetails transaction = new TransactionDetails();
        transaction.setAccountNo(account.getAccount_No());
        transaction.setTransactionType("debit");
        transaction.setAmount(amount);
        transaction.setDateTime(LocalDateTime.now());
        withdrawDAO.saveTransaction(transaction);

        return true;
    }
}
