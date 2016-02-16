package be.kdg.kandoe.backend.dom;

import be.kdg.kandoe.backend.dom.roles.Role;
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
public class User implements Serializable,UserDetails, Identifiable<Integer>{
    @Id
    @GeneratedValue
    @Column(name="UserId",nullable = false)
    private Integer userId;

    @Column(name = "Username", nullable = false)
    private String username = null;

    @Column(name = "Username", nullable = false, unique = true)
    private String email = null;

    @Column(name = "Password", nullable = true, length = 255)
    private String encryptedPassword;

    @Column(name = "Firstname", nullable = true, length = 255)
    private String firstname;

    @Column(name = "Lastname", nullable = true, length = 255)
    private String lastname;

    @OneToMany(targetEntity = Role.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private List<Role> roles;

    public List<Role> getRoles()
    {
        return roles;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
