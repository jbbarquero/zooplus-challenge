package com.josemorenoesteban.zooplus.challenge.service;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.josemorenoesteban.zooplus.challenge.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Ignore;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class UserAgentIT {
    @Autowired private UserAgent userAgent;
    
    @Test
    public void canCreateAndUser() {
        assertTrue( userAgent.signup("jomoespe@gmail.com", "thePassword") );
    }
}
