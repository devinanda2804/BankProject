package com.example.NewProject.Services;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.dao.DeleteAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DeleteService {

    @Autowired
    private DeleteAccountDAO deleteAccountDAO;

    @Transactional
    public boolean deleteAccnt(Integer accountNo) {
        AccountDetails account = deleteAccountDAO.findAccount(accountNo);

        if (account == null) {
            throw new IllegalArgumentException("Account number does not exist.");
        }

        if (account.getAccount_Balance() > 500) {
            throw new IllegalArgumentException("Balance is " + account.getAccount_Balance() + ". Please withdraw before closing.");
        } else if (account.getAccount_Balance() < 500) {
            throw new IllegalArgumentException("Balance is less than the minimum requirement. Unable to close.");
        } else {
            try {
                deleteAccountDAO.removeAccount(account);
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error occurred while deleting the account.");
            }
        }
    }
}
