package com.bank.Bank.Service;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Repository.AccountRepository;
import com.bank.Bank.Repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountTypeService {
@Autowired
AccountTypeRepository accountTypeRepository;

public ResponseEntity<AccountTypeModel> save(AccountTypeModel accountModel){
    try {
        AccountTypeModel saveAccountTypeModel = accountTypeRepository.save(accountModel);
        return new ResponseEntity<>(saveAccountTypeModel, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

public ResponseEntity<List<AccountTypeModel>> findAll(){
    try {
        List<AccountTypeModel> accountTypeModels = accountTypeRepository.findAll();
        return new ResponseEntity<>(accountTypeModels,HttpStatus.FOUND);
    }catch (Exception e){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }

}

public ResponseEntity<AccountTypeModel> findById(long id){
    if (accountTypeRepository.findById(id).isEmpty()){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    else{
        return new ResponseEntity<>(accountTypeRepository.findById(id).get(), HttpStatus.FOUND);
    }

}

public ResponseEntity<AccountTypeModel> deleteById(long id){
    if (accountTypeRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            accountTypeRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

}

public ResponseEntity<AccountTypeModel> update(long id, AccountTypeModel accountTypeModel){
        if (accountTypeRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            AccountTypeModel accountTypeModel1 =accountTypeRepository.findById(id).get();
            accountTypeModel1.setAccountType(accountTypeModel.getAccountType());
            accountTypeModel1.setDescription(accountTypeModel.getDescription());
            accountTypeModel1.setInterestRate(accountTypeModel.getInterestRate());
            accountTypeRepository.save(accountTypeModel1);
            return new ResponseEntity<>(accountTypeModel1,HttpStatus.ACCEPTED);
        }
}

}
