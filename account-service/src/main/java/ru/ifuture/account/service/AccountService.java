package ru.ifuture.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ifuture.account.mapper.AccountMapper;
import ru.ifuture.account.model.Account;
import ru.ifuture.account.repository.AccountRepository;
import ru.ifuture.dto.AccountDto;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

    private final MetricService metricService;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountDto addAmount(AccountDto accountDto) {
        Account account;
        if (accountRepository.existsById(accountDto.getId())) {
            account = findById(accountDto.getId());
            account.setValue(accountDto.getValue() + account.getValue());
        } else {
            account = accountMapper.fromDto(accountDto);
        }
        metricService.addCounterIncrement();
        return accountMapper.fromEntity(accountRepository.save(account));
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
        metricService.getCounterIncrement();
        return accountMapper.fromEntity(findById(id));
    }


}
