package com.bank.Bank.Service;

import com.bank.Bank.Model.BankModel;
import com.bank.Bank.Repository.BankRepository;
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
class BankServiceTest {

    @Mock
    BankRepository bankRepository;
    @InjectMocks
    BankService bankService;
    @Test
    void save() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        when(bankRepository.save(bankModel)).thenReturn(bankModel);
        ResponseEntity<BankModel> responseEntity = bankService.save(bankModel);
        assertEquals(bankModel,responseEntity.getBody());
    }
    @Test
    void saveException() {
        BankModel bankModel = null;
       Mockito.lenient().when(bankRepository.save(bankModel)).thenThrow(new RuntimeException());
        assertEquals(null,bankService.save(bankModel).getBody());

    }

    @Test
    void findAll() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        List<BankModel> bankModelList = new ArrayList<>();
        bankModelList.add(bankModel);

        Mockito.lenient().when(bankRepository.findAll()).thenReturn(bankModelList);
        assertNotNull(bankService.findAll());
    }

    @Test
    void findAllException() {
        Mockito.lenient().when(bankRepository.findAll()).thenThrow(new RuntimeException());
        assertEquals(null,bankService.findAll().getBody());
    }

    @Test
    void findById() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        long id=1L;
        when(bankRepository.findById(id)).thenReturn(Optional.of(bankModel));
        assertEquals(bankModel,bankService.findById(id).getBody());
    }

    @Test
    void findByIdException() {
        long id=1L;
        when(bankRepository.findById(id)).thenThrow( new RuntimeException());
        assertEquals(null,bankService.findById(id).getBody());
    }

    @Test
    void deleteById() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        long id=1L;
        when(bankRepository.findById(id)).thenReturn(null);
        assertEquals(HttpStatus.OK,bankService.deleteById(id).getStatusCode());
    }
@Test
    void deleteByIdException() {
        long id=1L;
        when(bankRepository.findById(id)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.NOT_FOUND,bankService.deleteById(id).getStatusCode());
    }
    @Test
    void update() {
        BankModel bankModel= new BankModel( 1L,"HNB","Batticalloa");
        long id=1L;
        bankModel.setBranch("avalanche");

        Mockito.lenient().when(bankRepository.findById(id)).thenReturn(Optional.of(bankModel));
        Mockito.lenient().when(bankRepository.save(bankModel)).thenReturn(bankModel);

        assertEquals(HttpStatus.ACCEPTED,bankService.update(id,bankModel).getStatusCode());
        assertEquals(bankModel,bankService.update(id,bankModel).getBody());
    }
@Test
    void updateException() {
        BankModel bankModel =null;
        Mockito.lenient().when(bankRepository.save(bankModel)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.NOT_FOUND,bankService.update(1L,bankModel).getStatusCode());
    }
}