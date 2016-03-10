package com.josemorenoesteban.zooplus.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.josemorenoesteban.zooplus.challenge.domain.Users;
import com.josemorenoesteban.zooplus.challenge.domain.UsersRepository;

@Component
public class UserAgent {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManagerBean;

    @Autowired
    private UsersRepository systemUsers;

    public boolean signup(final String firstname, final String lastname, final String email, final String bday, final String password) {
        Users newUser = new Users();
        newUser.setEmail(email);
        newUser.setPassword(new BCryptPasswordEncoder().encode(password));
        newUser.setEnabled(Boolean.TRUE);
        newUser.setFirstname(firstname);
        newUser.setLastname(lastname);
        newUser.setBirthday(bday);
        if (systemUsers.save(newUser) != null) {
            Authentication auth = authenticationManagerBean.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(auth);
            return auth.isAuthenticated();
        }
        return false;
    }

}
