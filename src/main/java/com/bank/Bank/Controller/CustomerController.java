package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.AccountRepository;
import com.bank.Bank.Repository.CustomerRepository;
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
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/save")
    public ResponseEntity<CustomerModel> save(@RequestBody CustomerModel customerModel){
        List<AccountModel> accountModelList =new ArrayList<>();
        for (AccountModel accountModel1:customerModel.getAccountModelList()) {
            accountRepository.save(accountModel1);
        }

        customerRepository.save(customerModel);

//
//        System.out.println(customerRepository.findById(customerModel.getCustomerId()));
//


    return null;

    }



    @GetMapping("findall")
    public ResponseEntity<List<CustomerModel>> getAll(){
        List<CustomerModel> customerModels  = customerRepository.findAll();
        if (customerModels.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(customerModels,HttpStatus.FOUND);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<CustomerModel> getById(@PathVariable long id){
        Optional<CustomerModel> customerModel  = customerRepository.findById(id);
        if (customerModel.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(customerRepository.findById(id).get(),HttpStatus.FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerModel> deleteById(@PathVariable long id) {
        if (customerRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }



    @PutMapping("update/{id}")
    public ResponseEntity<CustomerModel> update(@PathVariable long id, @RequestBody CustomerModel customerModel){
        if (customerRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            Optional<CustomerModel> customerModel1  =customerRepository.findById(id);
            customerModel1.get().setName(customerModel.getName());
            customerModel1.get().setAddress(customerModel.getAddress());
            customerModel1.get().setNic(customerModel.getNic());
            customerModel1.get().setPhone(customerModel.getPhone());
//            customerModel1.get().setBankModel(customerModel.getBankModel());


            customerRepository.save(customerModel1.get());
            return new ResponseEntity<>(customerModel1.get(),HttpStatus.ACCEPTED);
        }
    }







}

