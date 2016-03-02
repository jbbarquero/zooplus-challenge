package com.josemorenoesteban.zooplus.challenge.domain;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.josemorenoesteban.zooplus.challenge.ApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class ExchangeRateIT {
    
    @Autowired ExchangeRateRepository exchangeRates;
    @Autowired JdbcTemplate           jdbcTemplate;

    @Test
    public void testSave() {
        exchangeRates.save(create("USD", "EUR", System.currentTimeMillis(), 0.85642f, null));
        exchangeRates.save(create("USD", "JPY", System.currentTimeMillis(), 1.2f, null));
        exchangeRates.save(create("USD", "AUD", System.currentTimeMillis(), 1.16478f, null));
        exchangeRates.flush();

        assertEquals(3, JdbcTestUtils.countRowsInTable(jdbcTemplate, "exchangeRate"));  
    }

    private ExchangeRate create(String source, String target, Long timestamp, Float rate, 
                                String date) {
        ExchangeRate newExchangeRate = new ExchangeRate();
        newExchangeRate.setSource(source);
        newExchangeRate.setTarget(target);
        newExchangeRate.setRequestTimestamp(timestamp);
        newExchangeRate.setRate(rate);
        newExchangeRate.setRateDate(date);
        return newExchangeRate;
    }
}
