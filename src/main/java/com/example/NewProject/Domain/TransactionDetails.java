


package com.example.NewProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transactiondetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transaction_Id")
    private int transactionId;


    @Column(name = "Account_No")
    private Integer accountNo;
    @Column(name = "Transaction_Type")
    private String TransactionType;

    @Column(name = "Amount")
    private int Amount;
    @Column(name = "Date_Time")
    private LocalDateTime dateTime;




}