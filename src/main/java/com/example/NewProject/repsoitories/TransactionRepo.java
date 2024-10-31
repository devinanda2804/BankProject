package com.example.NewProject.repsoitories;

import com.example.NewProject.Domain.TransactionDetails;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepo extends JpaRepository<TransactionDetails, Integer> {
    List<TransactionDetails> findByAccountNo(Integer accountNo);

}
