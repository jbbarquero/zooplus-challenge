package com.josemorenoesteban.zooplus.challenge.domain;

import static org.junit.Assert.assertEquals;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.josemorenoesteban.zooplus.challenge.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UsersTest {

    @Autowired
    private UsersRepository systemUsers;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void canCreateAndCheckIfAnUserExist()
            throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        systemUsers.save(create("jomoespe@gmail.com", "password"));
        systemUsers.save(create("dparra@gmail.com", "another"));
        systemUsers.save(create("eroldan@gmail.com", "saurio"));

        assertEquals(3, JdbcTestUtils.countRowsInTable(jdbcTemplate, "users"));
    }

    private Users create(String email, String password)
            throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Users newUser = new Users();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setEnabled(Boolean.TRUE);
        return newUser;
    }
}
