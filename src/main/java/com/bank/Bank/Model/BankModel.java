package com.bank.Bank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "bank")
@AllArgsConstructor
@NoArgsConstructor
public class BankModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;
    @Column(name = "name")
    private String name;
    @Column(name = "branch")
        private String branch;
}
