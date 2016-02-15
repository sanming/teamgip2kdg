package be.kdg.kandoe.backend.dom.roles;

import be.kdg.kandoe.backend.dom.User;
import be.kdg.kandoe.backend.services.exceptions.UserServiceException;
import org.springframework.hateoas.Identifiable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by J.P on 15/02/2016.
 */
public abstract class Role implements Identifiable<Integer> {
    @Id
    @GeneratedValue
    @Column(name = "RoleId", nullable = false)
    private Integer roleId;
    @ManyToOne(targetEntity = User.class)
    private User user;

    public static <T extends Role> boolean hasRole(User user, Class<T> role) throws UserServiceException
    {
        try
        {
            loadRole(user, role);
            return true;
        }
        catch (UserServiceException use)
        {
            return false;
        }
    }

    public static <T extends Role> T loadRole(User user, Class<T> role) throws UserServiceException
    {
        List<Role> roles = user.getRoles();
        Optional<T> result = (Optional<T>) roles
                .stream()
                .filter(r -> role.isInstance(r))
                .findAny();

        if (!result.isPresent())
            throw new UserServiceException("Incorrect role for user");

        return result.get();
    }

    public static List<Role> createRoles(List<RoleType> roleTypes)
    {
        return roleTypes.stream().map(roleType -> toRole(roleType)).collect(Collectors.toList());
    }

    public static Role toRole(RoleType roleType)
    {
        switch (roleType)
        {
            case GUEST:
                return new Guest();
            case NORMAL:
                return new Normal();
            default:
                return new Organisator();
        }
    }

    public Integer getId()
    {
        return roleId;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public abstract Collection<? extends GrantedAuthority> getAuthorities();

    public abstract RoleType getRoleType();

    @Override
    public int hashCode()
    {
        return roleId.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return roleId.equals(role.roleId);

    }

    public enum RoleType
    {
        GUEST, NORMAL, ORGANISATOR
    }
}