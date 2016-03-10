package com.josemorenoesteban.zooplus.challenge.service.exchangerate;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.josemorenoesteban.zooplus.challenge.Application;
import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ExchangeRateServiceIT {

    @Autowired
    private ExchangeRateService rateService;

    @Test
    public void currentEuroDollarExchangeRate() {
        ExchangeRate rate = rateService.get("USD", "EUR");
        assertNotNull(rate);
    }
}
