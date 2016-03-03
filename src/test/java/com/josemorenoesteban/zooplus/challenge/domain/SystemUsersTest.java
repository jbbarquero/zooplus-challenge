package com.josemorenoesteban.zooplus.challenge.domain;

import static org.junit.Assert.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.josemorenoesteban.zooplus.challenge.ApplicationConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class SystemUsersTest {
    
    @Autowired private SystemUserRepository systemUsers;
    @Autowired private JdbcTemplate         jdbcTemplate;

    @Test
    public void canCreateAndCheckIfAnUserExist() throws NoSuchAlgorithmException, NoSuchPaddingException, 
                                                        IllegalBlockSizeException, BadPaddingException, 
                                                        InvalidKeyException {
        systemUsers.save(create("jomoespe@gmail.com", "password"));
        systemUsers.save(create("dparra@gmail.com",   "another"));
        
        assertEquals(2, JdbcTestUtils.countRowsInTable(jdbcTemplate, "systemUser"));

        assertEquals(1, systemUsers.countByEmailAndPassword("jomoespe@gmail.com", systemUsers.encrypt("password")));
        assertEquals(0, systemUsers.countByEmailAndPassword("jomoespe@gmail.com", systemUsers.encrypt("nop")));
        assertEquals(1, systemUsers.countByEmailAndPassword("dparra@gmail.com",   systemUsers.encrypt("another")));
        
        
        System.out.println(systemUsers.encrypt("password"));
    }

    private SystemUser create(String email, String password) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SystemUser newUser = new SystemUser();
        newUser.setEmail(email);
        newUser.setPassword(systemUsers.encrypt(password));
        return newUser;
    }
}
