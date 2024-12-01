package hkb.microservice.util;

import hkb.microservice.dto.route.RouteDto;
import hkb.microservice.model.BoundType;
import hkb.microservice.model.CoType;
import hkb.microservice.model.Route;
import hkb.microservice.model.RouteId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Converter {

    /**
     * Converts a RouteDto to a Route
     *
     * @author ryan.wu
     * @param datum a RouteDto
     * @param coType either "KMB", "CTB", or "NLB"
     * @return {@link Route}
     */
    public static Route convert(RouteDto datum, CoType coType) {
        return Route.builder()
                .id(RouteId.builder()
                        .id(datum.getRoute())
                        .bound(BoundType.valueOf(datum.getBound()).getValue())
                        .co(coType.getValue())
                        .build())
                .origEn(datum.getOrig_en())
                .origTc(datum.getOrig_tc())
                .destEn(datum.getDest_en())
                .destTc(datum.getDest_tc())
                .build();
    }

    /**
     * Converts a CTB RouteDto to a KMB-like RouteDto
     *
     * @author ryan.wu
     * @param datum a RouteDto
     * @param bound either "inbound" or "outbound"
     * @return {@link RouteDto}
     */
    private static RouteDto convert(RouteDto datum, BoundType bound) {
        if (Objects.requireNonNull(bound) == BoundType.INBOUND) {
            return datum.toBuilder().bound(BoundType.INBOUND.name()).build();
        }
        return datum.toBuilder()
                .bound(BoundType.OUTBOUND.name())
                .orig_en(datum.getDest_en())
                .orig_tc(datum.getDest_tc())
                .dest_en(datum.getOrig_en())
                .dest_tc(datum.getOrig_tc())
                .build();
    }

    /**
     * Converts a NLB RouteDto to a KMB-like RouteDto
     *
     * @author ryan.wu
     * @param datum a RouteDto
     * @return {@link RouteDto}
     */
    private static RouteDto convert(RouteDto datum) {
        var routeNameE = datum.getRouteName_e().split(">");
        var routeNameC = datum.getRouteName_c().split(">");
        return RouteDto.builder()
                .route(datum.getRouteId())
                .bound(BoundType.OUTBOUND.name())
                .orig_en(routeNameE[0])
                .orig_tc(routeNameC[0])
                .dest_en(routeNameE[1])
                .dest_tc(routeNameC[1])
                .build();
    }

    /**
     * Converts a CTB or NLB RouteDto list to a KMB-like RouteDto list
     *
     * @author ryan.wu
     * @param data a list of RouteDto
     * @param coType either "KMB", "CTB", or "NLB"
     * @return {@link List<RouteDto>}
     */
    public static List<RouteDto> convert(List<RouteDto> data, CoType coType) {
        return switch (coType) {
            case CTB -> new ArrayList<>() {{
                addAll(data.stream().map(datum -> convert(datum, BoundType.INBOUND)).toList());
                addAll(data.stream().map(datum -> convert(datum, BoundType.OUTBOUND)).toList());
            }};
            case NLB -> data.stream().map(Converter::convert).toList();
            default -> Collections.emptyList();
        };
    }

}
