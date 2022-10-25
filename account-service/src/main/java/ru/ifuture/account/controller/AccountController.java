package ru.ifuture.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ifuture.account.dto.AccountDto;
import ru.ifuture.account.service.AccountService;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

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
