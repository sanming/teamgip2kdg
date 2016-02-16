package be.kdg.kandoe.backend.dom;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by J.P on 15/02/2016.
 */
@Entity
@Table(name = "Circle")
public class Circle implements Serializable,Identifiable<Integer> {

    @Column(name = "CircleId", nullable = false)
    @Id
    @GeneratedValue
    private Integer circleId;

    @Override
    public Integer getId() {
        return null;
    }
}
