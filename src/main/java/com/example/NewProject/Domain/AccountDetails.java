package com.example.NewProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="accountdetails")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_No")
    private Integer Account_No;

    @Column(name = "Account_Balance")
    private int Account_Balance;

    @Column(name = "Date_Time", nullable = true)
    private LocalDateTime Date_Time;


    @OneToOne(mappedBy = "accountDetails", cascade = CascadeType.ALL)
    private Person person;
}




   /* public AccountDetails() {
    }

    public AccountDetails(int Account_Balance, LocalDateTime Date_Time) {
        this.Account_Balance = Account_Balance;
        this.Date_Time = Date_Time;
    }

    public int getAccount_Balance() {
        return Account_Balance;
    }

    public void setAccount_Balance(int account_Balance) {
        Account_Balance = account_Balance;
    }

    public int getAccount_No() {
        return Account_No;
    }

    public LocalDateTime getDate_Time() {
        return Date_Time;
    }

    public void setDate_Time(LocalDateTime date_Time) {
        Date_Time = date_Time;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/

