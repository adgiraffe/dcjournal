package org.bssimin;

import org.bssimin.dao.UserDAO;
import org.bssimin.domain.GeUser_info;
import org.bssimin.mapper.Db1Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by joo on 2017. 5. 23..
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DemocraticJounalismApplication.class)
public class UserMapperTest {
    @Autowired
    UserDAO dao;

    @Test
    public void readUserTest() throws Exception {
        GeUser_info geUser_info=dao.readGeUser("ozzz");
        String name=geUser_info.getGeUserId();
        System.out.println(name);

        assertThat("ozzz",is(geUser_info.getGeUserId()));
        assertThat("ozzznet@naver.com",is(geUser_info.getGeUserEmail()));
        assertThat("1234",is(geUser_info.getGeUserPw()));
    }

    @Test
    public void readAuthorityTest(){
        try {
            Collection<GrantedAuthority> authorities=dao.readAuthority("ozzz");
            System.out.println(authorities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
