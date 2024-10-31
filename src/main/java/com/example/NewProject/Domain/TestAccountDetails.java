package com.example.NewProject.Domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="test_accountdetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestAccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_no")
    private Integer accountNo;

    @Column(name = "account_balance")
    private int accountBalance;

    @Column(name = "date_time", nullable = true)
    private LocalDateTime dateTime;
}
