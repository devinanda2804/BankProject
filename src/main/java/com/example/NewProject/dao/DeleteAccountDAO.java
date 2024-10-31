package com.example.NewProject.dao;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TestAccountDetails;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class DeleteAccountDAO {


    @PersistenceContext
    private EntityManager entityManager;

    public AccountDetails findAccount(Integer accountNo) {
        return entityManager.find(AccountDetails.class, accountNo);
    }


    public  TestAccountDetails find(Integer number){
        return entityManager.find(TestAccountDetails.class,number);
    }

    @Transactional
    public void removeAccount(AccountDetails account) {
        account = entityManager.merge(account);
        entityManager.remove(account);
    }

    @Transactional
    public void removeAccnt(TestAccountDetails accountDetails){
        entityManager.remove(accountDetails);
    }

    public void saveAccount(TestAccountDetails accountDetails){
        entityManager.merge(accountDetails);
    }

}

