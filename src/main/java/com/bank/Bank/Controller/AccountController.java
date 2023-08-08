package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @PostMapping("/save")
    public ResponseEntity<AccountModel> save(@RequestBody AccountModel accountModel){
        AccountModel accountModel1 =accountRepository.save(accountModel);
        if(accountModel1!=null){
            return new ResponseEntity<>(accountModel, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findall")
    public ResponseEntity<List<AccountModel>> getAll(){
        List<AccountModel> accountModels  = accountRepository.findAll();
        if (accountModels.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(accountModels,HttpStatus.FOUND);
        }
    }


    @GetMapping("/findbyid/{id}")
    public ResponseEntity<AccountModel> getById(@PathVariable long id){
        Optional<AccountModel> accountModel  = accountRepository.findById(id);
        if (accountModel.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(accountRepository.findById(id).get(),HttpStatus.FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountModel> deleteById(@PathVariable long id) {
        if (accountRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            accountRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }


    @PutMapping("update/{id}")
    public ResponseEntity<AccountModel> update(@PathVariable long id, @RequestBody AccountModel accountModel){
        if (accountRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            Optional<AccountModel> accountModel1  =accountRepository.findById(id);
            accountModel1.get().setBalance(accountModel.getBalance());
            accountModel1.get().setOpenDate(accountModel.getOpenDate());
            accountModel1.get().setBankModel(accountModel.getBankModel());
            accountModel1.get().setAccountTypeModel(accountModel.getAccountTypeModel());
            accountModel1.get().setCustomerModel(accountModel.getCustomerModel());


            accountRepository.save(accountModel1.get());
            return new ResponseEntity<>(accountModel1.get(),HttpStatus.ACCEPTED);
        }
    }


}
