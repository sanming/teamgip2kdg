package be.kdg.kandoe.backend.dom;

import be.kdg.kandoe.backend.dom.roles.Role;

import java.util.List;

/**
 * Created by J.P on 15/02/2016.
 */
public class User {

    private List<Role> roles;
    private int id;

    public List<Role> getRoles()
    {
        return roles;
    }

    public int getId() {
        return id;
    }
}
