package com.bank.Bank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_type")
public class AccountTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTypeId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "description")
    private String description;

    @Column(name = "interest_rate")
    private Double interestRate;
}
