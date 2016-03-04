package com.josemorenoesteban.zooplus.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.josemorenoesteban.zooplus.challenge.domain.Users;
import com.josemorenoesteban.zooplus.challenge.domain.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class UserAgent {
    @Autowired private UsersRepository systemUsers;

    public boolean signup(String email, String password) {
        Users newUser = new Users();
        newUser.setEmail(email);
        newUser.setPassword( new BCryptPasswordEncoder().encode(password) );
        newUser.setEnabled(Boolean.TRUE);
        // Rest of signup fields
        return systemUsers.save(newUser) != null;
    } 

}
