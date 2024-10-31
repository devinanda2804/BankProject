package com.example.NewProject.Services;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.dao.AccountDAO;
import com.example.NewProject.dao.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Scanner;
@Service
public class DepositService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private AccountDAO accountDAO;

    public boolean deposit(int accountNo,int amount) {

            boolean message=accountDAO.depositAmount(accountNo,amount);
            return message;
        }
}

