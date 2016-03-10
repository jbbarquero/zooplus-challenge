package com.josemorenoesteban.zooplus.challenge.domain;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.josemorenoesteban.zooplus.challenge.Application;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ExchangeRateIT {

    @Autowired
    ExchangeRateRepository exchangeRates;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testMarkerMethod() {
    }

    @Test
    @Transactional
    public void testSave() {
        exchangeRates.save(create("USD", "EUR", System.nanoTime(), 1f, null));
        exchangeRates.save(create("USD", "JPY", System.nanoTime(), 2f, null));
        exchangeRates.save(create("USD", "AUD", System.nanoTime(), 3f, null));
        exchangeRates.save(create("USD", "GBP", System.nanoTime(), 4f, null));
        exchangeRates.save(create("USD", "JPY", System.nanoTime(), 5f, null));
        exchangeRates.save(create("USD", "AUD", System.nanoTime(), 6f, null));
        exchangeRates.flush();

        assertEquals(6, JdbcTestUtils.countRowsInTable(jdbcTemplate, "exchange_Rate"));

        // get the n las elements
        Pageable topTen = new PageRequest(0, 10, Sort.Direction.DESC, "requestTimestamp");
        List<ExchangeRate> last10 = exchangeRates.findAll(topTen).getContent();
        assertEquals(6, last10.size());

        exchangeRates.save(create("USD", "EUR", System.nanoTime(), 7f, null));
        exchangeRates.save(create("USD", "JPY", System.nanoTime(), 8f, null));
        exchangeRates.save(create("USD", "AUD", System.nanoTime(), 9f, null));
        exchangeRates.save(create("USD", "EUR", System.nanoTime(), 10f, null));
        exchangeRates.save(create("USD", "JPY", System.nanoTime(), 11f, null));
        exchangeRates.save(create("USD", "AUD", System.nanoTime(), 12f, null));
        exchangeRates.flush();

        assertEquals(12, JdbcTestUtils.countRowsInTable(jdbcTemplate, "exchange_Rate"));

        topTen = new PageRequest(0, 10, Sort.Direction.DESC, "requestTimestamp");
        last10 = exchangeRates.findAll(topTen).getContent();
        assertEquals(10, last10.size());
    }

    private ExchangeRate create(String source, String target, Long timestamp, Float rate, String date) {
        ExchangeRate newExchangeRate = new ExchangeRate();
        newExchangeRate.setSource(source);
        newExchangeRate.setTarget(target);
        newExchangeRate.setRateTimestamp(timestamp);
        newExchangeRate.setRate(rate);
        newExchangeRate.setRateDate(date);
        newExchangeRate.setRequestTimestamp(System.currentTimeMillis());
        return newExchangeRate;
    }
}
