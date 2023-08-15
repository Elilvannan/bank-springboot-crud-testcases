package com.bank.Bank.Service;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.AccountRepository;
import com.bank.Bank.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
@Mock
CustomerRepository customerRepository;
@Mock
AccountRepository accountRepository;
@InjectMocks
CustomerService customerService;


    @Test
    void save() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        when(customerRepository.save(customerModel)).thenReturn(customerModel);
        assertEquals(customerModel,customerService.save(customerModel).getBody());
    }
    @Test
    void saveException() {
        CustomerModel customerModel = null;
        when(customerRepository.save(customerModel)).thenThrow(new RuntimeException());
        assertEquals(null,customerService.save(customerModel).getBody());
    }
    @Test
    void findAll() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        List<CustomerModel> customerModels= new ArrayList<>();
        customerModels.add(customerModel);
        when(customerRepository.findAll()).thenReturn(customerModels);
        assertEquals(customerModels,customerService.findAll().getBody());
    }

    @Test
    void findAllException(){
        List<CustomerModel> customerModels=null;
        when(customerRepository.findAll()).thenThrow(new RuntimeException());
        assertEquals(null,customerService.findAll().getBody());
    }

    @Test
    void findById() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        CustomerModel customerModel = new CustomerModel(1L,"Elilvannan","batticalao","982831458V",756887873,accountModels,bankModel);
        long id=1L;
        when(customerRepository.findById(id)).thenReturn(Optional.of(customerModel));
        assertEquals(customerModel,customerService.findById(id).getBody());
    }
    @Test
    void findByIdException() {
       long id=1L;
        when(customerRepository.findById(id)).thenThrow(new RuntimeException());
        assertEquals(null,customerService.findById(id).getBody());
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
        when(customerRepository.findById(id)).thenReturn(Optional.of(customerModel));
        assertEquals(customerModel,customerService.findById(id).getBody());

    }

    @Test
    void deleteByIdException() {
        long id=1L;
        when(customerRepository.findById(id)).thenThrow(new RuntimeException());
        assertEquals(null,customerService.findById(id).getBody());
        assertEquals(HttpStatus.NOT_FOUND,customerService.deleteById(id).getStatusCode());
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
            customerModel.setName("Elilvanna");
            Mockito.lenient().when(customerRepository.findById(id)).thenReturn(Optional.of(customerModel));
            Mockito.lenient().when(customerRepository.save(customerModel)).thenReturn(customerModel);
            assertEquals(customerModel,customerService.update(id,customerModel).getBody());

    }

    @Test
    void updateException(){
        CustomerModel customerModel=null;
        long id =1L;
        when(customerRepository.findById(id)).thenThrow(new RuntimeException());
        assertEquals(null,customerService.update(id,customerModel).getBody());
    }

}