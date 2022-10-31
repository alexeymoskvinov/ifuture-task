package ru.ifuture.account.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.ifuture.account.service.AccountService;
import ru.ifuture.dto.AccountDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    final static Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    @PostMapping
    public AccountDto addAmount(@RequestBody @Valid AccountDto accountDto) {
        return accountService.addAmount(accountDto);
    }

    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable("id") int id) {
        return accountService.getAmount(id);
    }

}
