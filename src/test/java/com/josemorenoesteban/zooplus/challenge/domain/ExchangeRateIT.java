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
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class ExchangeRateIT {
    
    @Autowired ExchangeRateRepository exchangeRates;
    @Autowired JdbcTemplate           jdbcTemplate;

    @Test
    public void testSave() {
        exchangeRates.save(create("USD", "EUR", System.currentTimeMillis(),  1f, null));
        exchangeRates.save(create("USD", "JPY", System.currentTimeMillis(),  2f, null));
        exchangeRates.save(create("USD", "AUD", System.currentTimeMillis(),  3f, null));
        exchangeRates.save(create("USD", "EUR", System.currentTimeMillis(),  4f, null));
        exchangeRates.save(create("USD", "JPY", System.currentTimeMillis(),  5f, null));
        exchangeRates.save(create("USD", "AUD", System.currentTimeMillis(),  6f, null));
        exchangeRates.save(create("USD", "EUR", System.currentTimeMillis(),  7f, null));
        exchangeRates.save(create("USD", "JPY", System.currentTimeMillis(),  8f, null));
        exchangeRates.save(create("USD", "AUD", System.currentTimeMillis(),  9f, null));
        exchangeRates.save(create("USD", "EUR", System.currentTimeMillis(), 10f, null));
        exchangeRates.save(create("USD", "JPY", System.currentTimeMillis(), 11f, null));
        exchangeRates.save(create("USD", "AUD", System.currentTimeMillis(), 12f, null));
        exchangeRates.flush();

        assertEquals(12, JdbcTestUtils.countRowsInTable(jdbcTemplate, "exchangeRate"));
        
        final Pageable topTen = new PageRequest(0, 10, Sort.Direction.DESC, "requestTimestamp"); 
        
        List<ExchangeRate> last10 = exchangeRates.findAll(topTen).getContent();
        assertEquals(10, last10.size());
        
        last10.forEach(System.out::println);
        
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
