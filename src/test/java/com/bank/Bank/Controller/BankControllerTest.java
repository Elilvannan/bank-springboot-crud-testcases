package com.bank.Bank.Controller;

import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Service.BankService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankControllerTest {

    @Mock
    BankService bankService;
    @InjectMocks
    BankController bankController;

    @Test
    void createBank() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        when(bankService.save(bankModel)).thenReturn(new ResponseEntity<>(bankModel,HttpStatus.CREATED));
        assertNotNull(bankController.createBank(bankModel));
    }




    @Test
    void getAll() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        List<BankModel> bankModelList = new ArrayList<>();
        bankModelList.add(bankModel);

        when(bankService.findAll()).thenReturn(new ResponseEntity<>(bankModelList,HttpStatus.FOUND));
        assertNotNull(bankController.getAll());

    }


    @Test
    void getById() {
         BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
         long id=1L;
         when(bankService.findById(id)).thenReturn(new ResponseEntity<>(bankModel,HttpStatus.FOUND));
        assertNotNull(bankController.getById(id));
   }



    @Test
    void deleteById() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        long id =1L;
        when(bankService.deleteById(id)).thenReturn(new ResponseEntity<>(bankModel,HttpStatus.OK));
        assertNotNull(bankController.deleteById(id));
  }




    @Test
    void update() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        long id=1L;
        when(bankService.update(id,bankModel)).thenReturn(new ResponseEntity<>(bankModel,HttpStatus.ACCEPTED));
        assertNotNull(bankController.update(id,bankModel));
    }
}