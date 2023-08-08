package com.bank.Bank.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "open_date")
    private Date openDate;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankModel bankModel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountTypeModel accountTypeModel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customerModel;
}
