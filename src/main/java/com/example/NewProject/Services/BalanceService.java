package com.example.NewProject.Services;


import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.dao.BalanceDAO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class BalanceService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BalanceDAO balanceDAO;

    @Transactional
    public Integer balance(int accountNo){
        AccountDetails accountDetails=balanceDAO.findAccount(accountNo);
        if(accountDetails!=null){
            return balanceDAO.findBalance(accountDetails);
        }
        else {
            throw new IllegalArgumentException("Account not found");
        }
    }
}
