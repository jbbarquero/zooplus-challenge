package com.josemorenoesteban.zooplus.challenge.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.josemorenoesteban.zooplus.challenge.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserAgentIT {

    @Autowired
    private UserAgent userAgent;

    @Test
    public void canCreateAndUser() {
        assertTrue(userAgent.signup("", "", "jomoespe@gmail.com", "", "thePassword"));
    }
}
