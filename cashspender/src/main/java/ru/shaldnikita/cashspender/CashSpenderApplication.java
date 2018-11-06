package ru.shaldnikita.cashspender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class CashSpenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashSpenderApplication.class, args);
    }
}
