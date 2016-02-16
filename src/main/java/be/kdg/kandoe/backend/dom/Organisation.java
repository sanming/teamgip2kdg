package be.kdg.kandoe.backend.dom;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * This is the organisation object that a administrator can create. In an organisation the users/organisator
 * can create new themes (subjects) where users can play
 */
@Entity
@Table(name = "Organisation")
public class Organisation implements Serializable, Identifiable<Integer>{
    @Column(name = "OrganisationId", nullable = false)
    @Id
    @GeneratedValue
    private Integer organisationId;

    @Column(name = "OrganisationName", nullable = false, length = 20)
    private String organisationName;

    @OneToMany(targetEntity = Theme.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "organisation")
    private List<Theme> themes;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    public Organisation(String organisationName, List<Theme> themes, User user) {
        this.organisationName = organisationName;
        this.themes = themes;
        this.user = user;
    }

    public Organisation() {
    }

    @Override
    public Integer getId() {
        return organisationId;
    }


    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
