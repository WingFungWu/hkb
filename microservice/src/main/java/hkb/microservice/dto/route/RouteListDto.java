package hkb.microservice.dto.route;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RouteListDto {
    private String type;
    private String version;
    private String generated_timestamp;
    private List<RouteDto> data;
    private List<RouteDto> routes;
}
