package hkb.microservice.dto.route;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class RouteDto {
    private String route;
    private String bound;
    private String orig_tc;
    private String orig_en;
    private String dest_tc;
    private String dest_en;
    private String routeId;
    private String routeNo;
    private String routeName_c;
    private String routeName_e;
}
