package hkb.microservice.repository;

import hkb.microservice.model.Route;
import hkb.microservice.model.RouteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, RouteId>, JpaSpecificationExecutor<Route> {
}