package be.kdg.kandoe.backend.dom;

import be.kdg.kandoe.backend.dom.roles.Role;
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

    @OneToMany(targetEntity = Theme.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "mainTheme")
    private List<Theme> subThemes;

    @ManyToOne(targetEntity = Theme.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "MainThemeId",nullable = true)
    private Theme mainTheme;

    @OneToMany(targetEntity = Card.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "theme")
    private List<Card> cards;

    @ManyToOne(targetEntity = Organisation.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="OrganisationId",nullable = false)
    private Organisation organisation;

    @OneToOne(targetEntity = Circle.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="CircleId",nullable = false)
    private Circle circle;

    @OneToMany()
    private List<Role> roles;

    @Override
    public Integer getId() {
        return themeId;
    }
}
