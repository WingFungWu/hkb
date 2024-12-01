package hkb.microservice.service;

import hkb.microservice.dto.route.RouteDto;
import hkb.microservice.dto.route.RouteListDto;
import hkb.microservice.model.CoType;
import hkb.microservice.repository.RouteRepository;
import hkb.microservice.util.ConfigHelper;
import hkb.microservice.util.Converter;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

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

    public List<RouteDto> kmbRouteList() {
        var routeListDto = kmbRestTemplate.getForEntity(configHelper.getKmbRouteListUrl(), RouteListDto.class).getBody();
        if (routeListDto == null) return Collections.emptyList();
        routeRepository.saveAll(routeListDto.getData().stream().map(datum -> Converter.convert(datum, CoType.KMB)).toList());
        return routeListDto.getData();
    }

    public List<RouteDto> ctbRouteList() {
        var routeListDto = ctbRestTemplate.getForEntity(configHelper.getCtbRouteListUrl(), RouteListDto.class).getBody();
        if (routeListDto == null) return Collections.emptyList();
        routeRepository.saveAll(Converter.convert(routeListDto.getData(), CoType.CTB).stream().map(datum -> Converter.convert(datum, CoType.CTB)).toList());
        return routeListDto.getData();
    }

    public List<RouteDto> nlbRouteList() {
        var routeListDto = nlbRestTemplate.getForEntity(configHelper.getNlbRouteListUrl(), RouteListDto.class).getBody();
        if (routeListDto == null) return Collections.emptyList();
        routeRepository.saveAll(Converter.convert(routeListDto.getRoutes(), CoType.NLB).stream().map(datum -> Converter.convert(datum, CoType.NLB)).toList());
        return routeListDto.getRoutes();
    }
}
