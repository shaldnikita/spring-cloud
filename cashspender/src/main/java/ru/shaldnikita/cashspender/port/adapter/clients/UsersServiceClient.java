package ru.shaldnikita.cashspender.port.adapter.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shaldnikita.cashspender.domain.model.User;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@FeignClient(name = "users-service", url = "${users-service:}")
public interface UsersServiceClient {

    @GetMapping
    User getUser();
}
