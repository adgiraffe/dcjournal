package org.bssimin.config.security;

import org.bssimin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

/**
 * Created by joo on 2017. 5. 22..
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource db1DataSource;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
//        auth.jdbcAuthentication().dataSource(db1DataSource)
//                .usersByUsernameQuery("select geUserid,geUserPw, isEnabled from ge_user_info where geUserid='?'");//jdbc데이터베이스 이용 인증
//        auth.inMemoryAuthentication().withUser("joo").password("1234").roles("ADMIN")
//                .and()
//                    .withUser("user").password("1234").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home", "/about").permitAll()
                    .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                    .antMatchers("/user/**").hasAnyAuthority("USER")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")//로그인페이지 경로 지정
                .permitAll()
                    .usernameParameter("geUserId")//폼로그인시 username 파라미터를 getUserId 파라미터로 받는다//
                    .passwordParameter("geUserPw")//폼로그인시 paswword 파라미터를 getUserId 파라미터로 받는다//
                 .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        http.csrf().disable();


//
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/home", "/about").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("admin")
//                .antMatchers("/user/**").hasAnyRole("user")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .usernameParameter("geUserId")
//                    .passwordParameter("geUserPw") .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
}
