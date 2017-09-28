package org.bssimin.service;

import org.bssimin.dao.UserDAO;
import org.bssimin.domain.GeUser_info;
import org.bssimin.util.encryption.EncryptingPW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private EncryptingPW encryptingPW;


    @Override
    public UserDetails loadUserByUsername(String geUserId) throws UsernameNotFoundException {
        GeUser_info user = null;
        try {
            user = dao.readGeUser(geUserId);
            user.setAuthorities(getAutorities(geUserId));
            System.out.println(user.getAuthorities());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


//    @Override
//    public UserDetails loadUserByUsername(String geUserId) throws UsernameNotFoundException {
//        GeUser_info geUser_info = null;
//        try {
//            geUser_info = dao.readGeUser(geUserId);
//            System.out.println(geUser_info);
//            geUser_info.setAuthorities(getAutorities(geUserId));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return geUser_info;
//    }

    @Override
    public Collection<GrantedAuthority> getAutorities(String geUserId) throws Exception {
      Collection<GrantedAuthority> authorities=dao.readAuthority(geUserId);
      return authorities;
    }


    @Override
    public GeUser_info readUser(String geUserId) {
        GeUser_info user = null;
        try {
            user = dao.readGeUser(geUserId);
            user.setAuthorities(dao.readAuthority(geUserId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(GeUser_info user) {
        String rawPassword=user.getGeUserPw();
        String encodedPassword= new EncryptingPW().encode(rawPassword);
        user.setGeUserPw(encodedPassword);
        dao.createUser(user);
    }

    @Override
    public void deleteUser(String geUserId) throws Exception {
        dao.deleteUser(geUserId);
    }



}
