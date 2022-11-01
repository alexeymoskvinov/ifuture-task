package ru.ifuture.test.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestClientApplication.class, args);
	}

}
