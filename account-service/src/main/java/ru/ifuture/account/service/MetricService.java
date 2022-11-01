package ru.ifuture.account.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * metric service
 */
@Service
public class MetricService {

    @Autowired
    private MeterRegistry meterRegistry;
    @Getter
    private Counter getCounter;
    @Getter
    private Counter addCounter;

    /**
     * metric counter initialization
     */
    @PostConstruct
    public void counterInit() {
        getCounter =
                Counter.builder("account_get")
                        .description("number of GET requests")
                        .register(meterRegistry);
        addCounter =
                Counter.builder("number of ADD requests")
                        .description("")
                        .register(meterRegistry);
    }

    /**
     * get counter increment
     */
    public void getCounterIncrement(){
        getCounter.increment();
    }

    /**
     * add counter increment
     */
    public void addCounterIncrement(){
        addCounter.increment();
    }

}
