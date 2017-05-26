package org.bssimin.service;

import org.bssimin.dao.UserDAO;
import org.bssimin.domain.GeUser_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

/**
 * Created by joo on 2017. 5. 25..
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;


    @Override
    public UserDetails loadUserByUsername(String geUserId) throws UsernameNotFoundException {
        GeUser_info geUser_info = null;
        try {
            geUser_info = dao.readGeUser(geUserId);
            System.out.println(geUser_info);
            geUser_info.setAuthorities(getAutorities(geUserId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geUser_info;
    }

    @Override
    public Collection<GrantedAuthority> getAutorities(String geUserId) throws Exception {
      Collection<GrantedAuthority> authorities=dao.readAuthority(geUserId);
      System.out.println(authorities);
      return authorities;
    }



}
