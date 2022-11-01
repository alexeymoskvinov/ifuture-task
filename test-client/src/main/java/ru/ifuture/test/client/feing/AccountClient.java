package ru.ifuture.test.client.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.ifuture.dto.AccountDto;

@FeignClient(name = "AccountClient", url = "${account.service.url}")
public interface AccountClient {
    @PostMapping("/account")
    AccountDto addAmount(@RequestBody AccountDto accountDto);

    @GetMapping("/account/{id}")
    AccountDto getAmount(@PathVariable("id") int id);
}
