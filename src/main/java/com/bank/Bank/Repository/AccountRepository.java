package com.bank.Bank.Repository;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    List<AccountModel> findAllBycustomerModel(CustomerModel customerModel);

}
