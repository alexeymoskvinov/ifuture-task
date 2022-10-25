package ru.ifuture.test.client.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.ifuture.dto.AccountDto;

@FeignClient(name = "AccountClient", url = "http://localhost:8080")
public interface AccountClient {
    @PostMapping("/account")
    AccountDto addAmount(@RequestBody AccountDto accountDto);
}
