package com.josemorenoesteban.zooplus.challenge.service;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.josemorenoesteban.zooplus.challenge.ApplicationConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class UserAgentIT {
    @Autowired private UserAgent userAgent;
    
    @Test
    public void canCreateAndUser() {
        assertTrue( userAgent.signup("jomoespe@gmail.com", "thePassword") );
    }
}
