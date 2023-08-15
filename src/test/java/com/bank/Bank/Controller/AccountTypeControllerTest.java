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
import org.springframework.http.ResponseEntity;

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
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        when(accountTypeService.save(accountType)).thenReturn(new ResponseEntity<>(accountType,HttpStatus.CREATED));
        assertNotNull(accountTypeController.createTutorial(accountType));
   }

    @Test
    void findAll() {

        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        List<AccountTypeModel> accountTypeModels=new ArrayList<>();
        accountTypeModels.add(accountType);
        when(accountTypeService.findAll()).thenReturn(new ResponseEntity<>(accountTypeModels,HttpStatus.FOUND));
        assertNotNull(accountTypeController.findAll());
    }


    @Test
    void getbyid() {
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        long id=1;
        when(accountTypeService.findById(id)).thenReturn(new ResponseEntity<>(accountType,HttpStatus.FOUND));
        assertNotNull(accountTypeController.getbyid(id));
 }



    @Test
    void deleteByID() {

        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        long id=1;
        when(accountTypeService.deleteById(id)).thenReturn(new ResponseEntity<>(accountType,HttpStatus.FOUND));
        assertNotNull(accountTypeController.deleteByID(id));
    }



    @Test
    void update() {
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
     long id=1L;

        when(accountTypeService.update(id,accountType)).thenReturn(new ResponseEntity<>(accountType,HttpStatus.OK));
        assertNotNull(accountTypeController.update(id,accountType));
    }
}