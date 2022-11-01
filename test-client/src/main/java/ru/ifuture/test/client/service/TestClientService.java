package ru.ifuture.test.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifuture.dto.AccountDto;
import ru.ifuture.test.client.dto.TestClientDto;
import ru.ifuture.test.client.feing.AccountClient;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

@Service
@RequiredArgsConstructor
public class TestClientService {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    private final Random random = new Random();
    private final AccountClient accountClient;

    public void startTest(TestClientDto testClientDto) {
        executor.submit(() -> addAmount(testClientDto));
        executor.submit(() -> getAmount(testClientDto));
    }

    public void addAmount(TestClientDto testClientDto) {
        ForkJoinPool pool = new ForkJoinPool(testClientDto.getWCount());
        pool.submit(() ->
                testClientDto.getIdList().parallelStream()
                        .forEach(id -> accountClient.addAmount(AccountDto.builder()
                                .id(id)
                                .value(random.nextLong()).build())));
    }

    public void getAmount(TestClientDto testClientDto) {
        ForkJoinPool pool = new ForkJoinPool(testClientDto.getRCount());
        pool.submit(() ->
                testClientDto.getIdList().parallelStream().forEach(accountClient::getAmount));
    }
}
