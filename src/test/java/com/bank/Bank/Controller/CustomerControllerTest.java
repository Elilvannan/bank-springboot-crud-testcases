package com.bank.Bank.Controller;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.CustomerRepository;
import com.bank.Bank.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;
    @Test
    void save() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        when(customerService.save(customerModel)).thenReturn(new ResponseEntity<>(customerModel, HttpStatus.CREATED));
        assertNotNull(customerController.save(customerModel));

    }

    @Test
    void getAll() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        List<CustomerModel> customerModels= new ArrayList<>();
        customerModels.add(customerModel);

        Mockito.lenient().when(customerService.findAll()).thenReturn(new ResponseEntity<>(customerModels,HttpStatus.FOUND));
        assertNotNull(customerController.getAll());
    }

    @Test
    void getById() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        long id=1L;

        when(customerService.findById(id)).thenReturn(new ResponseEntity<>(customerModel,HttpStatus.CREATED));
        assertNotNull(customerController.getById(id));
    }

    @Test
    void deleteById() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        long id=1L;

        when(customerService.deleteById(id)).thenReturn(new ResponseEntity<>(customerModel,HttpStatus.OK));
        assertNotNull(customerController.deleteById(id));
    }

    @Test
    void update() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        long id=1L;

        when(customerService.update(id,customerModel)).thenReturn(new ResponseEntity<>(customerModel,HttpStatus.OK));
        assertNotNull(customerController.update(id,customerModel));
    }
}