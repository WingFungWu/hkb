package hkb.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoType {
    KMB("KMB"),
    CTB("CTB"),
    NLB("NLB")
    ;

    private final String value;
}
