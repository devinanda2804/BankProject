package com.example.NewProject.dao;


import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TransactionDetails;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public class AccountDAO {
   @PersistenceContext
   private EntityManager entityManager;

    public AccountDetails findAccountByAccountNo(Integer accountNo) {
        return entityManager.find(AccountDetails.class, accountNo);
    }

    @Transactional
    public boolean depositAmount(Integer accountNo,Integer amount) {
        AccountDetails account = entityManager.find(AccountDetails.class, accountNo);
        if (account != null) {

            account.setAccount_Balance(account.getAccount_Balance() + amount);
            entityManager.merge(account);

            TransactionDetails transaction = new TransactionDetails();
            transaction.setAccountNo(account.getAccount_No());
            transaction.setTransactionType("credit");
            transaction.setAmount(amount);
            transaction.setDateTime(LocalDateTime.now());
            entityManager.persist(transaction);

            return true;
        } else {
            return false;
        }
    }


    }

