package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Currency;

import com.josemorenoesteban.zooplus.challenge.service.RatingService;
import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


@Controller
public class AppController {
    @Autowired private RatingService ratingService;

    
    
    @RequestMapping(value="/", method=GET)
    public String home(final Model model) {
        model.addAttribute("currencies", getCurrencies());
        model.addAttribute("rate",       createExchange("USD", 1.1f));

        return "index"; 
    }

    @RequestMapping(value="/rate", method=GET)
    public String rate(final Model model) {
        model.addAttribute("currencies", getCurrencies());
        model.addAttribute("rate",       createExchange("USD", 1.1f));

        return "index"; 
    }

    @RequestMapping(value="/signup", method=GET)
    public String signup(final Model model) {
        return "signup"; // se retorna el nombre de la vista lógica
    }

    private Exchange.Rate createExchange(String currency, Float value) {
        Exchange.Rate rate = new Exchange.Rate();
        rate.setCurrency(Currency.getInstance(currency));
        rate.setExchange(value);
        return rate;
    }

    private Set<Currency> getCurrencies() {
        final Set<Currency> currencies = new LinkedHashSet() {{
            add(Currency.getInstance("EUR"));
            add(Currency.getInstance("USD"));
            add(Currency.getInstance("GBP"));
            add(Currency.getInstance("NZD"));
            add(Currency.getInstance("AUD"));
            add(Currency.getInstance("JPY"));
            add(Currency.getInstance("HUF"));
        }};
        return currencies;
    }
        
}
