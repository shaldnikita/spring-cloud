package ru.shaldnikita.cashspender.port.adapter.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shaldnikita.cashspender.application.costs.CostModel;

import java.util.List;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@FeignClient(value = "costs-service", url = "${costs-service:}")
public interface CostsServiceClient {

    @GetMapping("/costs")
    List<CostModel> getCosts();
}
