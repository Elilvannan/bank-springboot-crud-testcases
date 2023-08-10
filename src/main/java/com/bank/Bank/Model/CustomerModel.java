package com.bank.Bank.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "nic")
    private String nic;

    @Column(name = "phone")
    private Integer phone;

    @JsonBackReference
    @OneToMany(mappedBy = "customerModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AccountModel> accountModelList;


    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankModel bankModel;
}
