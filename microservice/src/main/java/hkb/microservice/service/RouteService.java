package hkb.microservice.service;

import hkb.microservice.repository.RouteRepository;
import hkb.microservice.util.ConfigHelper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
@Transactional
@RequiredArgsConstructor
public class RouteService {

    private final ConfigHelper configHelper;
    private final RouteRepository routeRepository;

    private RestTemplate kmbRestTemplate;
    private RestTemplate ctbRestTemplate;
    private RestTemplate nlbRestTemplate;

    @PostConstruct
    public void init() {
        kmbRestTemplate = new RestTemplateBuilder()
                .rootUri(configHelper.getKmbBaseUrl())
                .build();
        ctbRestTemplate = new RestTemplateBuilder()
                .rootUri(configHelper.getCtbBaseUrl())
                .build();
        nlbRestTemplate = new RestTemplateBuilder()
                .rootUri(configHelper.getNlbBaseUrl())
                .build();
    }


    public ResponseEntity<HashMap> test() {
        return kmbRestTemplate.getForEntity("/route", HashMap.class);
    }
}
