package org.bssimin.dao;

import org.bssimin.domain.GeUser_info;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Created by joo on 2017. 5. 23..
 */


public interface UserDAO {
    public GeUser_info readGeUser(String geUserId) throws Exception;
    public List <GrantedAuthority> readAuthority(String geUserId) throws Exception;
}
