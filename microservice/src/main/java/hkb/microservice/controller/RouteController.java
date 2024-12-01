package hkb.microservice.controller;

import hkb.microservice.dto.route.RouteDto;
import hkb.microservice.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/route")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/kmb")
    public ResponseEntity<List<RouteDto>> kmbRouteList() {
        return ResponseEntity.ok(routeService.kmbRouteList());
    }

    @GetMapping("/ctb")
    public ResponseEntity<List<RouteDto>> ctbRouteList() {
        return ResponseEntity.ok(routeService.ctbRouteList());
    }

    @GetMapping("/nlb")
    public ResponseEntity<List<RouteDto>> nlbRouteList() {
        return ResponseEntity.ok(routeService.nlbRouteList());
    }
}
