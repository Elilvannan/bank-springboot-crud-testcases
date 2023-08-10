package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Service.AccountService;
import com.bank.Bank.Service.AccountTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountTypeControllerTest {

    @Mock
    AccountTypeService accountTypeService;

    @InjectMocks
    AccountTypeController accountTypeController;

    @Test
    void createTutorial() {
//        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
//        when(accountTypeService.save(accountType)).thenReturn(accountType);
//        assertEquals(accountType,accountTypeController.createTutorial(accountType).getBody());
//        assertEquals(HttpStatus.CREATED,accountTypeController.createTutorial(accountType).getStatusCode());
    }

    @Test
    void createTutorialException() {
//        AccountTypeModel accountType =null;
//        when(accountTypeService.save(accountType)).thenThrow(new RuntimeException());
//        assertEquals(null,accountTypeController.createTutorial(accountType).getBody());
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,accountTypeController.createTutorial(null).getStatusCode());

    }

    @Test
    void findAll() {
//        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
//        List<AccountTypeModel> accountTypeModels=new ArrayList<>();
//        accountTypeModels.add(accountType);
//
//        when(accountTypeService.findAll()).thenReturn(accountTypeModels);
//        assertEquals(accountTypeModels,accountTypeController.findAll().getBody());
    }
    @Test
    void findAllException(){
//        when(accountTypeService.findAll()).thenThrow(new RuntimeException());
//        assertEquals(HttpStatus.NOT_FOUND,accountTypeController.findAll().getStatusCode());
    }



    @Test
    void getbyid() {
//        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
//        long id=1;
//        when(accountTypeService.findById(id)).thenReturn(Optional.of(accountType));
//        assertEquals(accountType,accountTypeController.getbyid(id).getBody());
//        assertEquals(HttpStatus.FOUND,accountTypeController.getbyid(id).getStatusCode());
    }
    @Test
    void getbyidException() {
//        long id=10;
//        assertEquals(HttpStatus.NOT_FOUND,accountTypeController.getbyid(id).getStatusCode());
    }


    @Test
    void deleteByID() {
//        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
//        long id=1;
//        when(accountTypeService.findById(id)).thenReturn(Optional.of(Optional.of(accountType).get()));
//        assertEquals(HttpStatus.OK,accountTypeController.deleteByID(id).getStatusCode());
    }

    @Test
    void deleteByIDException() {
//        long id=1;
//        assertEquals(HttpStatus.NOT_FOUND,accountTypeController.deleteByID(id).getStatusCode());
    }

    @Test
    void update() {
//        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
//        AccountTypeModel accountType2 = new AccountTypeModel(1L,"aj","demo2",20.00);
//        long id=1L;
//
//        accountType.setDescription(accountType2.getDescription());
//        Mockito.lenient().when(accountTypeService.findById(id)).thenReturn(Optional.of(accountType));
//        assertEquals(accountType,accountTypeController.update(id,accountType2).getBody());

    }
    @Test
    void updateException() {
//        long id = 1L;
//        AccountTypeModel accountTypeModel =null;
//        assertEquals(HttpStatus.NOT_FOUND,accountTypeController.update(id,accountTypeModel).getStatusCode());
    }
}