package hkb.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoundType {
    I("inbound"),
    INBOUND("inbound"),
    O("outbound"),
    OUTBOUND("outbound")
    ;

    private final String value;
}
