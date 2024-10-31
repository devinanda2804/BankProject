package com.example.NewProject.dao;


import com.example.NewProject.Domain.AccountDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BalanceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public AccountDetails findAccount(int accountNo){
        return entityManager.find(AccountDetails.class,accountNo);
    }
    public Integer findBalance(AccountDetails accountDetails){
        return accountDetails.getAccount_Balance();

    }
}
