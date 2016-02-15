package be.kdg.kandoe.frontend.config.orika.custom.convertors;

import be.kdg.kandoe.backend.dom.roles.Role;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;
import org.springframework.stereotype.Component;

@Component
public class RoleRoleTypeConvertor extends CustomConverter<Role, Role.RoleType>
{
    // https://programmeren3-repaircafe.rhcloud.com/repair-cafe-applicatie/repair-cafe-frontend/presentation-layer/orika/

    @Override
    public Role.RoleType convert(Role role, Type<? extends Role.RoleType> type)
    {
        return role.getRoleType();
    }

}