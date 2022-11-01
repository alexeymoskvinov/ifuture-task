package ru.ifuture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    /**
     * id
     */
    private Integer id;
    /**
     * value at account
     */
    @NotNull
    private Long value;

}
