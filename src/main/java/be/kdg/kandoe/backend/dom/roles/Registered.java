package be.kdg.kandoe.backend.dom.roles;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by J.P on 15/02/2016.
 */
public class Registered extends Role {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public RoleType getRoleType() {
        return RoleType.REGISTERED;
    }
}
