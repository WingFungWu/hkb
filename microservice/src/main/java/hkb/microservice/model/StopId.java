package hkb.microservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StopId implements Serializable {
    @Serial
    private static final long serialVersionUID = -1317569622206739459L;
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "co", nullable = false)
    private String co;

    @Column(name = "bound", nullable = false)
    private String bound;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StopId entity = (StopId) o;
        return Objects.equals(this.bound, entity.bound) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.co, entity.co);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bound, id, co);
    }

}