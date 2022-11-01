package ru.ifuture.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ifuture.account.service.AccountService;
import ru.ifuture.dto.AccountDto;

import javax.validation.Valid;


/**
 * account controller
 */
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    /**
     * add amount
     *
     * @param accountDto info about account
     * @return info about new account
     */
    @PostMapping
    public AccountDto addAmount(@RequestBody @Valid AccountDto accountDto) {
        return accountService.addAmount(accountDto);
    }

    /**
     * get amount
     *
     * @param id id of account
     * @return info about account
     */
    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable("id") int id) {
        return accountService.getAmount(id);
    }

}
