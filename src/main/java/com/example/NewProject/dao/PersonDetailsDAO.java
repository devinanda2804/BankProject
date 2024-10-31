package com.example.NewProject.dao;

import com.example.NewProject.Domain.AccountDetails;
import com.example.NewProject.Domain.Person;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public class PersonDetailsDAO {
    private static  final Logger logger = LogManager.getLogger(PersonDetailsDAO.class);



        @PersistenceContext
        private EntityManager entityManager;

        public void saveAccount(AccountDetails account) {
            entityManager.persist(account);
        }

        public void savePerson(Person person) {
            entityManager.persist(person);
        }
    }

