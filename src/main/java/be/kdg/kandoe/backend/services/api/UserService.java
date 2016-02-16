/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.kandoe.backend.services.api;

import be.kdg.kandoe.backend.dom.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


/**
 * @author wouter
 */
public interface UserService extends UserDetailsService {

    List<User> getAllUsers();
}
