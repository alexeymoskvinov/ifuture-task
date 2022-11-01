package ru.ifuture.account.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ifuture.account.BaseTest;
import ru.ifuture.account.mapper.AccountMapper;
import ru.ifuture.account.repository.AccountRepository;
import ru.ifuture.dto.AccountDto;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest extends BaseTest {

    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountMapper accountMapper;
    AccountDto accountDto;

    @BeforeEach
    void setUp() {
        accountDto = new AccountDto();
        accountDto.setId(1);
        accountDto.setValue(100L);
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    void addAmount() {
        AccountDto accountDto1 = accountService.addAmount(accountDto);
        assertTrue(accountRepository.existsById(accountDto.getId()));
        assertEquals(accountDto1.getId(),accountDto.getId());
        assertEquals(accountDto1.getValue(),accountDto.getValue());
    }

    @Test
    void getAmountWithStatusOK() {
        accountRepository.save(accountMapper.fromDto(accountDto));
        AccountDto accountDto1 = accountService.getAmount(accountDto.getId());
        assertEquals(accountDto1.getId(),accountDto.getId());
        assertEquals(accountDto1.getValue(),accountDto.getValue());
    }

    @Test
    void getAmountWithNotFoundException() {
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> accountService.getAmount(0));
        assertEquals("Account not found by id = 0", exception.getMessage());
    }
}