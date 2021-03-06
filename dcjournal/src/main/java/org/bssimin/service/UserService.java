package org.bssimin.service;

import org.bssimin.domain.GeUser_info;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

/**
 * Created by joo on 2017. 5. 25..
 */
public interface UserService extends UserDetailsService {
    Collection<GrantedAuthority> getAutorities(String geUserId) throws Exception;
//    public GeUser_info readUser(String geUserId) throws Exception;
}
