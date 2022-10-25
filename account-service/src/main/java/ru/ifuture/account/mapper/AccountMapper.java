package ru.ifuture.account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ifuture.account.dto.AccountDto;
import ru.ifuture.account.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    AccountDto fromEntity(Account account);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "value", source = "value")
    Account fromDto(AccountDto accountDto);
}
