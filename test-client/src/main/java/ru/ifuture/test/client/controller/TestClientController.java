package ru.ifuture.test.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifuture.dto.TestClientDto;
import ru.ifuture.test.client.service.TestClientService;


@RestController
@RequestMapping("/test-client-start")
@RequiredArgsConstructor
public class TestClientController {

    private final TestClientService testClientService;

    @PostMapping
    public void startTest(@RequestBody TestClientDto testClientDto) {
        testClientService.startTest(testClientDto);
    }
}
