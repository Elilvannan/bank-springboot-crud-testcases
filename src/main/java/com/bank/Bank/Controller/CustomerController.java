package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.AccountRepository;
import com.bank.Bank.Repository.CustomerRepository;
import com.bank.Bank.Service.AccountService;
import com.bank.Bank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;


    @PostMapping("/save")
    public ResponseEntity<CustomerModel> save(@RequestBody CustomerModel customerModel){

        return customerService.save(customerModel);

    }



    @GetMapping("findall")
    public ResponseEntity<List<CustomerModel>> getAll(){
        return customerService.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<CustomerModel> getById(@PathVariable long id){
       return customerService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerModel> deleteById(@PathVariable long id) {

        return customerService.deleteById(id);
    }



    @PutMapping("update/{id}")
    public ResponseEntity<CustomerModel> update(@PathVariable long id, @RequestBody CustomerModel customerModel){

        return customerService.update(id,customerModel);
    }


    



}

