package com.bank.Bank.Service;


import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.AccountRepository;
import com.bank.Bank.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<CustomerModel> save(CustomerModel customerModel) {

        try {
            CustomerModel customerModel1 = customerRepository.save(customerModel);
            for (AccountModel accountModel : customerModel.getAccountModelList()
            ) {
                accountModel.setCustomerModel(customerModel1);
                accountRepository.save(accountModel);
            }
            return new ResponseEntity<>(customerModel1, HttpStatus.CREATED);
        }catch ( Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<List<CustomerModel>> findAll() {
       try {
           List<CustomerModel> customerModels = customerRepository.findAll();
           return new ResponseEntity<>(customerModels, HttpStatus.FOUND);
       }catch ( Exception e){
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }

    public ResponseEntity<CustomerModel> findById(long id) {
       try {
           Optional<CustomerModel> customerModel = customerRepository.findById(id);
           return new ResponseEntity<>(customerRepository.findById(id).get(), HttpStatus.FOUND);
       }catch ( Exception e){
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }

    public ResponseEntity<CustomerModel> deleteById(long id) {
        try {
            Optional<CustomerModel> customerModel = customerRepository.findById(id);
            List<AccountModel> accountModelList;
            accountModelList = accountRepository.findAllBycustomerModel(customerModel.get());
            accountRepository.deleteAll(accountModelList);
            customerRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch ( Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<CustomerModel> update( long id,  CustomerModel customerModel){
        try {
            Optional<CustomerModel> customerModel1  =customerRepository.findById(id);
            customerModel1.get().setName(customerModel.getName());
            customerModel1.get().setAddress(customerModel.getAddress());
            customerModel1.get().setNic(customerModel.getNic());
            customerModel1.get().setPhone(customerModel.getPhone());
            customerModel1.get().setBankModel(customerModel.getBankModel());
            customerRepository.save(customerModel1.get());
            return new ResponseEntity<>(customerModel1.get(),HttpStatus.ACCEPTED);

        }catch ( Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
