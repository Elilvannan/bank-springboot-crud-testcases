package com.bank.Bank.Service;

import com.bank.Bank.Model.AccountModel;
import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Model.CustomerModel;
import com.bank.Bank.Repository.AccountRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

@Mock
AccountRepository accountRepository;
@InjectMocks
AccountService accountService;


    @Test
    void save() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        Mockito.lenient().when(accountRepository.save(accountModel)).thenReturn(accountModel);
        assertNotNull(accountService.save(accountModel));
        assertEquals(accountModel,accountService.save(accountModel).getBody());
    }

    @Test
    void SaveException() {
        AccountModel accountModel = null;
        when(accountRepository.save(accountModel)).thenThrow(new RuntimeException());
        assertEquals(null,accountService.save(accountModel).getBody());

    }

    @Test
    void findAll() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());

        List<AccountModel> accountModels= new ArrayList<>();
        accountModels.add(accountModel);

        when(accountRepository.findAll()).thenReturn(accountModels);
        assertEquals(accountModels,accountService.findAll().getBody());
    }


    @Test
    void findAllException() {
        when(accountRepository.findAll()).thenThrow(new RuntimeException());
        assertEquals(null,accountService.findAll().getBody());
    }

    @Test
    void findById() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
        long id=1L;
        when(accountRepository.findById(id)).thenReturn(Optional.of(accountModel));
        assertEquals(accountModel,accountService.findById(id).getBody());
    }
    @Test
    void findByIdException() {
        long id=1L;
        when(accountRepository.findById(id)).thenThrow(new RuntimeException());
        assertEquals(null,accountService.findById(id).getBody());
    }
    @Test
    void deleteById() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
        long id=1L;

        when(accountRepository.findById(id)).thenReturn(null);
        assertEquals(null,accountService.deleteById(id).getBody());
    }

    @Test
    void deleteByIdException() {
        long id=1L;
        when(accountRepository.findById(id)).thenThrow(new RuntimeException());
        assertEquals(null,accountService.deleteById(id).getBody());
        assertEquals(HttpStatus.NOT_FOUND,accountService.deleteById(id).getStatusCode());
    }
    @Test
    void update() {
        BankModel bankModel= new BankModel(1L,"HNB","jaffna");
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        AccountModel accountModel = new AccountModel(1L,1000.00,new Date(),bankModel,accountType,new CustomerModel());
        long id=1L;

        accountModel.setBalance(1221.22);

        Mockito.lenient().when(accountRepository.findById(id)).thenReturn(Optional.of(accountModel));
        Mockito.lenient().when(accountRepository.save(accountModel)).thenReturn(accountService.update(id,accountModel).getBody());
    }

    @Test
    void updateException() {
    AccountModel accountModel=null;
    long id =1L;
    Mockito.lenient().when(accountRepository.findById(id)).thenThrow( new RuntimeException());
    assertEquals(null,accountService.update(id,accountModel).getBody());
    }
}