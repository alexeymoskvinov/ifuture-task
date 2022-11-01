package ru.ifuture.account.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.ifuture.account.BaseTest;
import ru.ifuture.account.mapper.AccountMapper;
import ru.ifuture.account.repository.AccountRepository;
import ru.ifuture.account.service.AccountService;
import ru.ifuture.dto.AccountDto;

import static org.junit.jupiter.api.Assertions.*;

class AccountControllerTest extends BaseTest {
    @Autowired
    AccountController accountController;
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
    void addAmount() throws Exception {
        String uri = "/account";
        String inputJson = mapToJson(accountDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        AccountDto accountDto1 = mapFromJson(content, AccountDto.class);
        assertNotNull(accountDto1.getId());
        assertNotNull(accountDto1.getValue());
    }

    @Test
    void getById() throws Exception {
        accountRepository.save(accountMapper.fromDto(accountDto));
        String uri = "/account/%s";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(String.format(uri, accountDto.getId()))
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        AccountDto accountDto1 = mapFromJson(content, AccountDto.class);
        assertEquals(accountDto1.getId(),accountDto.getId());
        assertEquals(accountDto1.getValue(),accountDto.getValue());
    }
}