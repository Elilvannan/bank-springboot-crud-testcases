package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Repository.AccountTypeRepository;
import com.bank.Bank.Service.AccountTypeService;
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
    AccountTypeService accountTypeService;


    @PostMapping("/save")
    public ResponseEntity<AccountTypeModel> createTutorial(@RequestBody AccountTypeModel accountTypeModel) {
       return accountTypeService.save(accountTypeModel);
    }

    @GetMapping("findall")
    public ResponseEntity<List<AccountTypeModel>> findAll(){
       return accountTypeService.findAll();
    }


    @GetMapping("findbyid/{id}")
    public ResponseEntity<AccountTypeModel> getbyid(@PathVariable long id){
        return accountTypeService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<AccountTypeModel> deleteByID(@PathVariable long id){
        return accountTypeService.deleteById(id);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<AccountTypeModel> update(@PathVariable long id,@RequestBody AccountTypeModel accountTypeModel){

        return accountTypeService.update(id,accountTypeModel);
    }
}
