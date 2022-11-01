package ru.ifuture.test.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TestClientDto {

    /**
     * rCount - количество читателей вызывающих метод getAmount(id)
     */
    @JsonProperty(value="rCount")
    private Integer rCount;

    /**
     * wCount - количество читателей вызывающих метод addAmount(id,value)
     */
    @JsonProperty(value="wCount")
    private Integer wCount;

    /**
     * idList - список или доапазон ключей которые будут использоваться для тестирования
     */
    private List<Integer> idList;
}
