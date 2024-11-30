package hkb.microservice.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ConfigHelper {
    @Value("${kmb.base.url}")
    private String kmbBaseUrl;
    @Value("${ctb.base.url}")
    private String ctbBaseUrl;
    @Value("${nlb.base.url}")
    private String nlbBaseUrl;
}
