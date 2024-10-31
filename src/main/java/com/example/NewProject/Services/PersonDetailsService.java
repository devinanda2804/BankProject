package com.example.NewProject.Services;
import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.Person;

import com.example.NewProject.dao.PersonDetailsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;


@Service
public class PersonDetailsService {

    private static final Logger logger = LogManager.getLogger(PersonDetailsService.class);


    @Autowired
    private PersonDetailsDAO personDetailsDAO;
    @Transactional
    public void PersonDetail(Person person) throws Exception {


        try {

            AccountDetails account = new AccountDetails();
            account.setAccount_Balance(0);
            account.setDate_Time(LocalDateTime.now());

            personDetailsDAO.saveAccount(account);
            person.setAccountNo(account.getAccount_No());

            personDetailsDAO.savePerson(person);

            logger.info("Data inserted successfully into account and person tables");
        } catch (Exception e) {
            logger.error("Transaction failed: {}", e.getMessage());
            throw new Exception("Transaction failed: " + e.getMessage());
        }
    }
}

