package ru.shaldnikita.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import ru.shaldnikita.auth.domain.entity.User;
import ru.shaldnikita.auth.service.UserService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }


    @Autowired
    private UserService userService;

    @Bean
    public ApplicationRunner applicationRunner() {
        return (args) -> {
            User user = new User("shaldnikita", "123");
            this.userService.create(user);
        };
    }
}

