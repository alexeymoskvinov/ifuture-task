package ru.ifuture.account.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AccountDto {
    /**
     * id
     */
    @NotNull
    private Long id;
    /**
     * value at account
     */
    @NotNull
    private Long value;

}
