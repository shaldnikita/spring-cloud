package ru.shaldnikita.costs.port.adapter.costs;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.shaldnikita.costs.application.model.CostModel;

/**
 * @author n.shaldenkov on 06.11.2018
 */
@RestController
class ZipkinController{

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(ZipkinController.class.getName());



    @GetMapping(value="/zipkin/{id}")
    public String zipkinService1(@PathVariable String id)
    {
        LOG.info("Inside zipkinService 1..");

        CostModel response = restTemplate.exchange("http://localhost:7000/costs/costs/"+id,
                HttpMethod.GET, null, new ParameterizedTypeReference<CostModel>() {}).getBody();
        return "Hi...";
    }
}