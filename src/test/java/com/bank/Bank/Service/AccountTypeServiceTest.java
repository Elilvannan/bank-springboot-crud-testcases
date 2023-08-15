package com.bank.Bank.Service;

import com.bank.Bank.Model.AccountTypeModel;
import com.bank.Bank.Repository.AccountTypeRepository;
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
class AccountTypeServiceTest {

    @Mock
    AccountTypeRepository accountTypeRepository;
    @InjectMocks
    AccountTypeService accountTypeService;
    @Test
    void save() {
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        when(accountTypeRepository.save(accountType)).thenReturn(accountType);
        assertEquals(accountType,accountTypeService.save(accountType).getBody());
    }
@Test
    void saveException() {
        AccountTypeModel accountType=null;
        when(accountTypeRepository.save(accountType)).thenThrow( new RuntimeException());
        assertEquals(null,accountTypeService.save(accountType).getBody());
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED,accountTypeService.save(accountType).getStatusCode());
    }
    @Test
    void findAll() {
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        List<AccountTypeModel> accountTypeModels = new ArrayList<>();
        accountTypeModels.add(accountType);

        when(accountTypeRepository.findAll()).thenReturn(accountTypeModels);
        assertEquals(accountTypeModels,accountTypeService.findAll().getBody());
    }

    @Test
    void findAllExcetiom() {
        List<AccountTypeModel> accountTypeModels = new ArrayList<>();
        accountTypeModels=null;
        when(accountTypeRepository.findAll()).thenThrow(new RuntimeException());
        assertEquals(null,accountTypeService.findAll().getBody());
        assertEquals(HttpStatus.NOT_FOUND,accountTypeService.findAll().getStatusCode());

    }

    @Test
    void findById() {
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        long id = 1L;
        when(accountTypeRepository.findById(id)).thenReturn(Optional.of(accountType));
        assertEquals(accountType,accountTypeService.findById(id).getBody());
        assertEquals(HttpStatus.FOUND,accountTypeService.findById(id).getStatusCode());
    }

    @Test
    void findByIdException() {
        long id = 1L;
        when(accountTypeRepository.findById(id)).thenThrow( new RuntimeException());
        assertEquals(null,accountTypeService.findById(id).getBody());
        assertEquals(HttpStatus.NOT_FOUND,accountTypeService.findById(id).getStatusCode());
    }

    @Test
    void deleteById() {
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        long id = 1L;
        when(accountTypeRepository.findById(id)).thenReturn(null);
        assertEquals(HttpStatus.OK,accountTypeService.deleteById(id).getStatusCode());
    }
    @Test
    void deleteByIdException() {
        long id = 1L;
        when(accountTypeRepository.findById(id)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.NOT_FOUND,accountTypeService.deleteById(id).getStatusCode());
    }

    @Test
    void update() {
        AccountTypeModel accountType = new AccountTypeModel(1L,"normal","demo",15.54);
        long id = 1L;
        accountType.setDescription("Demo");
        Mockito.lenient().when(accountTypeRepository.findById(id)).thenReturn(Optional.of(accountType));
        Mockito.lenient().when(accountTypeRepository.save(accountType)).thenReturn(accountType);

        assertEquals(accountType,accountTypeService.update(id,accountType).getBody());
    }
}