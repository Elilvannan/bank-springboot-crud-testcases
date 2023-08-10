package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.AccountRepository;
import com.bank.Bank.Repository.CustomerRepository;
import com.bank.Bank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerRepository customerRepository;


    @PostMapping("/save")
    public ResponseEntity<AccountModel> save(@RequestBody AccountModel accountModel){
       return accountService.save(accountModel);
    }

    @GetMapping("findall")
    public ResponseEntity<List<AccountModel>> getAll(){
       return accountService.findAll();
    }


    @GetMapping("/findbyid/{id}")
    public ResponseEntity<AccountModel> getById(@PathVariable long id){
        return accountService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountModel> deleteById(@PathVariable long id) {
        return accountService.deleteById(id);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<AccountModel> update(@PathVariable long id, @RequestBody AccountModel accountModel){

        return accountService.update(id,accountModel);
    }

}
