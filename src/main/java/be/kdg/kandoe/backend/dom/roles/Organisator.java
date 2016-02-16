package be.kdg.kandoe.backend.dom.roles;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by claudiu on 16/02/16.
 */
public class Organisator extends Role {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public RoleType getRoleType() {
        return RoleType.ORGANISATOR;
    }
}
