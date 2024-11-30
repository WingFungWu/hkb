package hkb.microservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "route")
public class Route {
    @EmbeddedId
    private RouteId id;

    @Column(name = "orig_en")
    private String origEn;

    @Column(name = "orig_tc")
    private String origTc;

    @Column(name = "dest_en")
    private String destEn;

    @Column(name = "dest_tc")
    private String destTc;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

}