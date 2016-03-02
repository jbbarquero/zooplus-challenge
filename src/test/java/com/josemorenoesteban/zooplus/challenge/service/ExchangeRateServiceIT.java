package com.josemorenoesteban.zooplus.challenge.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.josemorenoesteban.zooplus.challenge.ApplicationConfiguration;
import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class ExchangeRateServiceIT {
    @Autowired private ExchangeRateService rateService;
    
    @Test public void currentEuroDollarExchangeRate() {
        ExchangeRate rate = rateService.get("USD", "EUR");
        assertNotNull(rate);
    }
}
