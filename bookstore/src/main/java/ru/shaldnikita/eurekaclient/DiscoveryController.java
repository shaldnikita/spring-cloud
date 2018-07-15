package ru.shaldnikita.eurekaclient;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/applications")
    public Applications getApplications() {
        return eurekaClient.getApplications();
    }
}