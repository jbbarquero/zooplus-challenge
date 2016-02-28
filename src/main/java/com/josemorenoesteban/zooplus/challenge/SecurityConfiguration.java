package com.josemorenoesteban.zooplus.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * http://docs.spring.io/spring-security/site/docs/3.2.x/guides/hellomvc.html
 * http://docs.spring.io/spring-security/site/docs/3.2.x/guides/form.html
 * http://o7planning.org/web/fe/default/en/document/29799/simple-login-web-application-using-spring-mvc-spring-security-and-spring-jdbc
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");
    }    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin().and()//.loginPage("/signup").permitAll().and()
            //.httpBasic().and()
            .logout().permitAll();
    }
}
