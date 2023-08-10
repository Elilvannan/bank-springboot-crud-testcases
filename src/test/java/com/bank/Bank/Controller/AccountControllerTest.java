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
//        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
//        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
//        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
//        when(accountService.save(accountModel)).thenReturn(accountModel);
//        assertEquals(accountType,accountController.save(accountModel).getBody());

    }

    @Test
    void saveException() {
//        AccountModel accountModel = new AccountModel();
//        Mockito.lenient().when(accountService.save(accountModel)).thenThrow(new RuntimeException());
//        assertEquals(HttpStatus.BAD_REQUEST,accountController.save(accountModel).getStatusCode());

    }



    @Test
    void getAll() {
//        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
//        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
//        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
//
//        List<AccountModel> accountModels= new ArrayList<>();
//        accountModels.add(accountModel);
//
//        when(accountService.findAll()).thenReturn(accountModels);
//        assertEquals(accountModels,accountController.getAll().getBody());
    }


    @Test
    void getAllException() {
//
//        AccountModel accountModel = new AccountModel();
//        Mockito.lenient().when(accountService.findAll().isEmpty()).thenReturn(empty());
//        assertEquals(HttpStatus.NOT_FOUND,accountController.getAll().getStatusCode());
    }

    @Test
    void getById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }
}