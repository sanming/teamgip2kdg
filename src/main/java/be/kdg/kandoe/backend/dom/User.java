package be.kdg.kandoe.backend.dom;

import be.kdg.kandoe.backend.dom.roles.Role;
import org.hibernate.annotations.Fetch;
import org.springframework.hateoas.Identifiable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by J.P on 15/02/2016.
 */
@Entity
@Table(name = "`User`")
public class User implements Serializable,UserDetails, Identifiable<Integer>{
    @Id
    @GeneratedValue
    @Column(name="UserId",nullable = false)
    private Integer userId;

    @Column(name = "Username", nullable = false)
    private String username = null;

    @Column(name = "Email", nullable = false, unique = true)
    private String email = null;

    @Column(name = "Password", nullable = true, length = 255)
    private String encryptedPassword;

    @Column(name = "Firstname", nullable = true, length = 255)
    private String firstname;

    @Column(name = "Lastname", nullable = true, length = 255)
    private String lastname;

    @ManyToOne(targetEntity = Organisation.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Organisation> organisations;

    @OneToMany(targetEntity = Role.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @Fetch(org.hibernate.annotations.FetchMode.SELECT)     // for some strange reason we need to add this, see: http://stackoverflow.com/questions/1995080/hibernate-criteria-returns-children-multiple-times-with-fetchtype-eager
    private List<Role> roles;

    //TODO: Constructor


    public User() {
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    @Override
    public Integer getId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return encryptedPassword;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
