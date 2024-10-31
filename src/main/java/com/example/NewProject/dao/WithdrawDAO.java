package com.example.NewProject.dao;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TransactionDetails;
import javafx.beans.value.ObservableBooleanValue;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class WithdrawDAO {


    @PersistenceContext
    private EntityManager entityManager;


    public AccountDetails findAccount(int accountNo) {
        return entityManager.find(AccountDetails.class, accountNo);
    }

    public void updateAccount(AccountDetails account) {

        entityManager.merge(account);
    }

    public void saveTransaction(TransactionDetails transaction) {
        entityManager.persist(transaction);
    }
    }

