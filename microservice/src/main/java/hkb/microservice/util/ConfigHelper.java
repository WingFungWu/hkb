package hkb.microservice.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ConfigHelper {
    @Value("${kmb.base.url}")
    private String kmbBaseUrl;
    @Value("${kmb.route.list.url}")
    private String kmbRouteListUrl;

    @Value("${ctb.base.url}")
    private String ctbBaseUrl;
    @Value("${ctb.route.list.url}")
    private String ctbRouteListUrl;

    @Value("${nlb.base.url}")
    private String nlbBaseUrl;
    @Value("${nlb.route.list.url}")
    private String nlbRouteListUrl;
}
