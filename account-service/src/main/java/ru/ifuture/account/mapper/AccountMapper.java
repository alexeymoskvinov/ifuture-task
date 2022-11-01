package ru.ifuture.account.mapper;

import org.mapstruct.Mapper;
import ru.ifuture.account.model.Account;
import ru.ifuture.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto fromEntity(Account account);

    Account fromDto(AccountDto accountDto);
}
