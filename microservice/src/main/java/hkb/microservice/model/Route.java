package hkb.microservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route")
public class Route {
    @EmbeddedId
    private RouteId id;

    @Column(name = "name")
    private String name;

    @Column(name = "orig_en")
    private String origEn;

    @Column(name = "orig_tc")
    private String origTc;

    @Column(name = "dest_en")
    private String destEn;

    @Column(name = "dest_tc")
    private String destTc;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    @PrePersist
    protected void onCreate() {
        lastUpdateTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdateTime = LocalDateTime.now();
    }

}