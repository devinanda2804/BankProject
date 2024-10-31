package com.example.NewProject.dao;

import com.example.NewProject.Domain.TransactionDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TransactionDAO {

  @PersistenceContext
  private EntityManager entityManager;

    public List<TransactionDetails> getTransactionsByAccount(Integer accountNo) {
        String query = "SELECT t FROM TransactionDetails t WHERE t.accountNo = :accountNo ORDER BY t.dateTime";
        TypedQuery<TransactionDetails> typedQuery = entityManager.createQuery(query, TransactionDetails.class);
        typedQuery.setParameter("accountNo", accountNo);
        return typedQuery.getResultList();
    }

}
