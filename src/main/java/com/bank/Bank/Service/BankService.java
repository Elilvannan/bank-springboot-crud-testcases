package com.bank.Bank.Service;

import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BankService {
@Autowired
    BankRepository bankRepository;
    public ResponseEntity<BankModel> save(BankModel bankModel){
        if(bankModel.equals(null)){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(bankRepository.save(bankModel), HttpStatus.CREATED);
        }

    }

    public ResponseEntity<List<BankModel>> findAll(){
        List<BankModel> bankModelList = bankRepository.findAll();
        if (bankModelList.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(bankModelList,HttpStatus.FOUND);
        }


    }

    public ResponseEntity<BankModel> findById(long id)
    {
        Optional<BankModel> bankModel = bankRepository.findById(id);
        if (bankModel.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(bankRepository.findById(id).get(),HttpStatus.FOUND);

        }

    }

    public ResponseEntity<BankModel> deleteById(long id){
        if (bankRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            bankRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

    }

    public ResponseEntity<BankModel> update(long id,BankModel bankmodel) {
            if (bankRepository.findById(id).isEmpty()){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }else{
        Optional<BankModel> bankModel1 =bankRepository.findById(id);
        bankModel1.get().setName(bankmodel.getName());
        bankModel1.get().setBranch(bankmodel.getBranch());
        bankRepository.save(bankModel1.get());
        return new ResponseEntity<>(bankModel1.get(),HttpStatus.ACCEPTED);
    }

    }
}
