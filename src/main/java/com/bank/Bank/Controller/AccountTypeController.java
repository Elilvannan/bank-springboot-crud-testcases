package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accountType")
public class AccountTypeController {

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @PostMapping("/save")
    public ResponseEntity<AccountTypeModel> createTutorial(@RequestBody AccountTypeModel accountTypeModel) {
        try {
            AccountTypeModel saveAccountTypeModel = accountTypeRepository
                    .save(accountTypeModel);
            return new ResponseEntity<>(saveAccountTypeModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("findall")
    public ResponseEntity<List<AccountTypeModel>> findAll(){
        try {
            List<AccountTypeModel> accountTypeModels = accountTypeRepository.findAll();
            return new ResponseEntity<>(accountTypeModels,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping("findbyid/{id}")
    public ResponseEntity<AccountTypeModel> getbyid(@PathVariable long id){
        if(accountTypeRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(accountTypeRepository.findById(id).get(),HttpStatus.FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<AccountTypeModel> deleteByID(@PathVariable long id){
        if (accountTypeRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            accountTypeRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }


    @PutMapping("update/{id}")
    public ResponseEntity<AccountTypeModel> update(@PathVariable long id,@RequestBody AccountTypeModel accountTypeModel){
        if (accountTypeRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            Optional<AccountTypeModel> accountTypeModel1 =accountTypeRepository.findById(id);
            accountTypeModel1.get().setAccountType(accountTypeModel.getAccountType());
            accountTypeModel1.get().setDescription(accountTypeModel.getDescription());
            accountTypeModel1.get().setInterestRate(accountTypeModel.getInterestRate());
            accountTypeRepository.save(accountTypeModel1.get());
            return new ResponseEntity<>(accountTypeModel1.get(),HttpStatus.ACCEPTED);
        }
    }
}
