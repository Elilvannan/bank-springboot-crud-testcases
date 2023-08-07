package com.bank.Bank.Controller;

import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Repository.BankRepository;
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
@PostMapping("/save")
    public ResponseEntity<BankModel> createBank(@RequestBody BankModel bankModel){
           BankModel bankModel1 =bankRepository.save(bankModel);
        if(bankModel1!=null){
            return new ResponseEntity<>(bankModel1,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

 @GetMapping("findall")
    public ResponseEntity<List<BankModel>> getAll(){
     List<BankModel> bankModelList = bankRepository.findAll();
     if (bankModelList.isEmpty()){
         return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
     }else {
         return new ResponseEntity<>(bankModelList,HttpStatus.FOUND);
     }
 }

@GetMapping("/findbyid/{id}")
    public ResponseEntity<BankModel> getById(@PathVariable long id){
        Optional<BankModel> bankModel = bankRepository.findById(id);
        if (bankModel.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(bankRepository.findById(id).get(),HttpStatus.FOUND);

        }
    }



@DeleteMapping("/delete/{id}")
    public ResponseEntity<BankModel> deleteById(@PathVariable long id) {
    if (bankRepository.findById(id).isEmpty()) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
        bankRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }


@PutMapping("update/{id}")
public ResponseEntity<BankModel> update(@PathVariable long id, @RequestBody BankModel bankModel){
    if (bankRepository.findById(id).isEmpty()){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }else{
        Optional<BankModel> bankModel1 =bankRepository.findById(id);
        bankModel1.get().setName(bankModel.getName());
        bankModel1.get().setBranch(bankModel.getBranch());
        bankRepository.save(bankModel1.get());
        return new ResponseEntity<>(bankModel1.get(),HttpStatus.ACCEPTED);
    }
}


}
