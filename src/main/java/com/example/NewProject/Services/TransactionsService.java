package com.example.NewProject.Services;

import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.dao.AccountDAO;
import com.example.NewProject.dao.TransactionDAO;
import com.example.NewProject.repsoitories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {

    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private AccountDAO accountDAO;

    public List<TransactionDetails> getTransactionsByAccount(Integer accountNo) {

        AccountDetails account=accountDAO.findAccountByAccountNo(accountNo);
        if (account == null) {
            throw new IllegalArgumentException("Account number does not exist.");
        }
        /*List<TransactionDetails> transactions=transactionDAO.getTransactionsByAccount(accountNo);
        return transactions;*/
        return transactionRepo.findByAccountNo(accountNo);
    }
}


