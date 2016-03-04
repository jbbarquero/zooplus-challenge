package com.josemorenoesteban.zooplus.challenge;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * http://docs.spring.io/spring-security/site/docs/3.2.x/guides/hellomvc.html
 * http://docs.spring.io/spring-security/site/docs/3.2.x/guides/form.html
 * http://o7planning.org/web/fe/default/en/document/29799/simple-login-web-application-using-spring-mvc-spring-security-and-spring-jdbc
 */
//@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired DataSource dataSource;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            //.passwordEncoder(new BCryptPasswordEncoder())
            .usersByUsernameQuery("SELECT email, password, enabled FROM users WHERE email=?")
            .authoritiesByUsernameQuery("SELECT email, 'user' FROM users WHERE email=?");
    }    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/style/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/scripts/**").permitAll()
                .anyRequest().authenticated() //hasAnyRole("user")//
                .and()
            .formLogin()
//                .loginPage("/signin")
//                .defaultSuccessUrl("/")
//                .failureUrl("/signin?error")
//                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
//            .logout().logoutSuccessUrl("/signin").and()
//	    .exceptionHandling().accessDeniedPage("/403").and()
            .csrf();
    }
}
