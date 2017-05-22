package org.bssimin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by joo on 2017. 5. 22..
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource db1DataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(db1DataSource);//jdbc데이터베이스 이용 인증
        auth.inMemoryAuthentication().withUser("joo").password("1234").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/**").permitAll();

        http.formLogin()
                .usernameParameter("geUserId")//폼로그인시 username 파라미터를 getUserId 파라미터로 받는다//
                .passwordParameter("geUserPw")//폼로그인시 paswword 파라미터를 getUserId 파라미터로 받는다//
                .loginPage("/login")//로그인페이지 경로 지정
                .failureForwardUrl("/login");
        http.csrf().disable();
    }
}
