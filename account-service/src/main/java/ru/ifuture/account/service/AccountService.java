package ru.ifuture.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ifuture.account.dto.AccountDto;
import ru.ifuture.account.mapper.AccountMapper;
import ru.ifuture.account.model.Account;
import ru.ifuture.account.repository.AccountRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j

public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountDto addAmount(AccountDto accountDto) {

        return accountMapper.fromEntity(accountRepository.save(accountMapper.fromDto(accountDto)));
    }

    private Account findById(int id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> {
                    log.error("Account not found by id = {}", id);
                    throw new EntityNotFoundException("Account not found by id = " + id);
                });
    }

    public AccountDto getAmount(int id) {
        return accountMapper.fromEntity(findById(id));
    }


}
