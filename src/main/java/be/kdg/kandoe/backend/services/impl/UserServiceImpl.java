package be.kdg.kandoe.backend.services.impl;

import be.kdg.kandoe.backend.dom.User;
import be.kdg.kandoe.backend.services.api.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yiua on 15/02/16.
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
