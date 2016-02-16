package be.kdg.kandoe.backend.dom;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Theme")
public class Theme implements Serializable,Identifiable<Integer>{
    @Id
    @GeneratedValue
    @Column(name = "ThemeId", nullable = false)
    private Integer themeId;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Tags", nullable = false)
    private String tags;

    @Column(name = "GameMode", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private GameMode gameMode;

    
    @Override
    public Integer getId() {
        return themeId;
    }
}
