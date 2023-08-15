package com.bank.Bank.Controller;

import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Repository.BankRepository;
import com.bank.Bank.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankRepository bankRepository;
    @Autowired
    BankService bankService;
@PostMapping("/save")
    public ResponseEntity<BankModel> createBank(@RequestBody BankModel bankModel){
           ResponseEntity<BankModel> bankModel1 =bankService.save(bankModel);
        return new ResponseEntity<>(bankModel1.getBody(),bankModel1.getStatusCode());
    }

 @GetMapping("findall")
    public ResponseEntity<List<BankModel>> getAll(){
    return bankService.findAll();
 }

@GetMapping("/findbyid/{id}")
    public ResponseEntity<BankModel> getById(@PathVariable long id){
        return bankService.findById(id);
    }



@DeleteMapping("/delete/{id}")
    public ResponseEntity<BankModel> deleteById(@PathVariable long id) {
        return bankService.deleteById(id);
}


@PutMapping("update/{id}")
public ResponseEntity<BankModel> update(@PathVariable long id, @RequestBody BankModel bankModel){
    return bankService.update(id,bankModel);
}
}
