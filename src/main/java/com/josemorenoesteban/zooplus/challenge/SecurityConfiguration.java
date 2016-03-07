package com.josemorenoesteban.zooplus.challenge;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * http://docs.spring.io/spring-security/site/docs/3.2.x/guides/hellomvc.html
 * http://docs.spring.io/spring-security/site/docs/3.2.x/guides/form.html
 * http://o7planning.org/web/fe/default/en/document/29799/simple-login-web-application-using-spring-mvc-spring-security-and-spring-jdbc
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired private DataSource dataSource;
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            //.passwordEncoder( new BCryptPasswordEncoder() )
            .usersByUsernameQuery("SELECT email, password, enabled FROM users WHERE email=?")
            .authoritiesByUsernameQuery("SELECT email, 'user' FROM users WHERE email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers(GET,  "/favicon.ico", "/style/**").permitAll()
                .antMatchers(POST, "/signup").permitAll()
                .anyRequest().authenticated() //hasAnyRole("user")//
                .and()
                .formLogin()
                    .loginPage("/signin")
                    .defaultSuccessUrl("/")
                    .failureUrl("/signin?error")
                    .permitAll()
                 .and()
                .logout()
                    .logoutSuccessUrl("/signin")
                    .permitAll()
//                .and()
//                .exceptionHandling()
//                    .accessDeniedPage("/403")
                .and()
                .csrf();
    }
}
