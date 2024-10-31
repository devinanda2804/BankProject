package com.demo.repo;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.NewProjectApplication;
import com.example.NewProject.dao.DeleteAccountDAO;
import com.example.NewProject.repsoitories.TransactionRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = NewProjectApplication.class)

public class TransactionRepoTest {

    @Autowired
    private TransactionRepo transactionRepo;

    @Test
    public void getListTransaction(){

        List<TransactionDetails> details= transactionRepo.findAll();
        Assertions.assertThat(details).isNotNull();
        System.out.println(details.size());
        Assertions.assertThat(details.size()).isGreaterThan(0);

    }

    @Test
    public void testByAccountNo(){
        List<TransactionDetails> transactionDetails=transactionRepo.findByAccountNo(1);
        Assertions.assertThat(transactionDetails).isNotNull();
        Assertions.assertThat(transactionDetails.size()).isGreaterThan(0);

        TransactionDetails details=transactionDetails.get(0);
        Assertions.assertThat(details.getAccountNo()).isEqualTo(1);
    }

}
