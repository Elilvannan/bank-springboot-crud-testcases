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
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        when(bankService.save(bankModel)).thenReturn(bankModel);
//        assertEquals(bankModel,bankController.createBank(bankModel).getBody());
//        ResponseEntity<BankModel> responseEntity = bankController.createBank(bankModel);
    }
    @Test
    void createBankException() {
//        BankModel bankModel= new BankModel( );
//        Mockito.when(bankService.save(bankModel)).thenReturn(null);
//        assertEquals(HttpStatus.BAD_REQUEST,bankController.createBank(bankModel).getStatusCode());
//        ResponseEntity<BankModel> responseEntity = bankController.createBank(bankModel);

    }


    @Test
    void getAll() {
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        List<BankModel> bankModelList = new ArrayList<>();
//        bankModelList.add(bankModel);
//        when(bankService.findAll()).thenReturn(bankModelList );
//        assertEquals(bankModelList,bankController.getAll().getBody());
    }

    @Test
    void getAllException() {
//        List<BankModel> bankModelList = new ArrayList<>();
//        when(bankService.findAll()).thenReturn(bankModelList);
//        assertEquals(HttpStatus.NOT_FOUND,bankController.getAll().getStatusCode());
//        assertEquals(null,bankController.getAll().getBody());
    }


    @Test
    void getById() {
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        long id=bankModel.getBankId();
//        Mockito.when(bankService.findById(id)).thenReturn(Optional.of(bankModel));
//        assertEquals(bankModel,bankController.getById(bankModel.getBankId()).getBody());
    }

    @Test
    void getByIdException() {
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        long id=2;
//        Mockito.when(bankService.findById(id)).thenReturn(Optional.empty());
//        assertEquals(HttpStatus.NOT_FOUND,bankController.getById(id).getStatusCode());

    }

    @Test
    void deleteById() {
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        long id=1;
//        Mockito.lenient().when(bankService.findById(id)).thenReturn(Optional.of(bankModel));
//        assertEquals(HttpStatus.OK,bankController.deleteById(id).getStatusCode());
    }
    @Test
    void deleteByIdException() {
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        long id=2;
//        Mockito.lenient().when(bankService.findById(id)).thenReturn(Optional.empty());
//        assertEquals(HttpStatus.NOT_FOUND,bankController.deleteById(id).getStatusCode());
    }

    @Test
    void updateExcepetion() {
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        long id=2;
//        when(bankService.findById(id)).thenReturn(Optional.empty());
//        assertEquals(null,bankController.update(id,bankModel).getBody());

    }

    @Test
    void update() {
//        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
//        long id=1;
//        when(bankService.findById(id)).thenReturn(Optional.of(bankModel));
//        assertEquals(bankModel,bankController.update(id,bankModel).getBody());

    }
}