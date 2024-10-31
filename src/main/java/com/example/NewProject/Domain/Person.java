package com.example.NewProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="persondetails")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    @Id
    @Column(name = "Account_No")
    private Integer accountNo;
    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private String dob;

    @OneToOne
    @JoinColumn(name = "Account_No", referencedColumnName = "Account_No", nullable = false)
    private AccountDetails accountDetails;



   /* public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
        accountDetails.setPerson(this); // Link back to the person
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }
    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }*/
}

