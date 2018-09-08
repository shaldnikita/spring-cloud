package ru.shaldnikita.readers.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shaldnikita.readers.domain.User;

/**
 * @author n.shaldenkov on 07.09.2018
 */
@FeignClient(name = "auth-service", url = "${auth-service.url}")
public interface AuthServiceFeignClient {

    @PostMapping(value = "/auth/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(User user);
}
