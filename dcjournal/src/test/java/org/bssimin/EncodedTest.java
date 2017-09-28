package org.bssimin;


import org.bssimin.dao.UserDAO;
import org.bssimin.dao.UserDaoImpl;
import org.bssimin.domain.GeUser_info;
import org.bssimin.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Named;
import java.util.Collection;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EncodedTest {

    @Autowired
    UserService service;

    private GeUser_info user1=new GeUser_info();

    @Before
    public void setup(){
        user1.setGeUserId("adgiraffe");
        user1.setGeUserPw("1234");
        user1.setAccountNonExpired(true);
        user1.setAccountNonLocked(true);
        user1.setCredentialsNonExpired(true);
        user1.setEnabled(true);
        user1.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
    }

    @Test
    public void createUserTest() throws Exception {
        System.out.println(user1.getGeUserId());
        String geUserId=user1.getGeUserId();

        service.deleteUser(geUserId);
        service.createUser(user1);
        GeUser_info user=service.readUser(user1.getGeUserId());
        assertThat(user.getGeUserId(),is(user1.getGeUserId()));
        PasswordEncoder passwordEncoder=service.passwordEncoder();
        assertThat(passwordEncoder.matches("1234",user.getPassword()),is(true));

        Collection<? extends GrantedAuthority> authorities1=user1.getAuthorities();
        Iterator<? extends GrantedAuthority> it=authorities1.iterator();
        Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>) user.getAuthorities();
        while (it.hasNext()){
            GrantedAuthority authority=it.next();
            assertThat(authorities,hasItem(new SimpleGrantedAuthority(authority.getAuthority())));
        }

    }
}
