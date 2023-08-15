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
        try {

            return new ResponseEntity<>(bankRepository.save(bankModel), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<BankModel>> findAll(){
        try {
            List<BankModel> bankModelList = bankRepository.findAll();
            return new ResponseEntity<>(bankModelList,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<BankModel> findById(long id) {try {
            Optional<BankModel> bankModel = bankRepository.findById(id);
            return new ResponseEntity<>(bankRepository.findById(id).get(),HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<BankModel> deleteById(long id){
        try {
            bankRepository.findById(id);
            bankRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<BankModel> update(long id,BankModel bankmodel) {

        try {
            Optional<BankModel> bankModel1 =bankRepository.findById(id);
            bankModel1.get().setName(bankmodel.getName());
            bankRepository.save(bankModel1.get());
            return new ResponseEntity<>(bankModel1.get(),HttpStatus.ACCEPTED);
        }catch ( Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
