package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Service.AccountService;
import com.google.protobuf.Empty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.OptionalDouble.empty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    AccountService accountService;
@InjectMocks
AccountController accountController;


    @Test
    void save() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        Mockito.lenient().when(accountService.save(accountModel)).thenReturn(new ResponseEntity<>(accountModel,HttpStatus.CREATED));
        assertNotNull(accountController.save(accountModel));
    }




    @Test
    void getAll() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        when(accountService.findAll()).thenReturn(new ResponseEntity<>(accountModels,HttpStatus.FOUND));
        assertNotNull(accountController.getAll());

    }




    @Test
    void getById() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
        long id=1L;

        when(accountService.findById(id)).thenReturn(new ResponseEntity<>(accountModel,HttpStatus.FOUND));
        assertNotNull(accountController.getById(id));
    }

    @Test
    void deleteById() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
        long id=1L;

        when(accountService.deleteById(id)).thenReturn(new ResponseEntity<>(accountModel,HttpStatus.OK));
        assertNotNull(accountController.deleteById(id));
    }

    @Test
    void update() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
        long id=1L;

        when(accountService.update(id,accountModel)).thenReturn(new ResponseEntity<>(accountModel,HttpStatus.OK));
        assertNotNull(accountController.update(id,accountModel));
    }
}