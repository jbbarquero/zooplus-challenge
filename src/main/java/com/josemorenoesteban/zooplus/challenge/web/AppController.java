package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josemorenoesteban.zooplus.challenge.service.ExchangeRateAgent;
import com.josemorenoesteban.zooplus.challenge.service.GetExchangeRateResponse;

@Controller
public class AppController {
    @Autowired ExchangeRateAgent exchangeAgent;
    
    @RequestMapping(value="/", method=GET)
    public String home(final Model model) {
        model.addAttribute("currencies", exchangeAgent.currencies());
        model.addAttribute("searchs",    exchangeAgent.last());

        return "index"; 
    }
    
    @RequestMapping(value="/rate", method=GET)
    public String rate(@RequestParam("target") final String target, 
                       final Model model) {
        GetExchangeRateResponse response = exchangeAgent.get("USD", target);
        
        model.addAttribute("currencies", exchangeAgent.currencies());
        model.addAttribute("searchs",    response.getLatstSearches());
        model.addAttribute("rate",       response.getCurrent());
        
        return "index"; 
    }

    @RequestMapping(value="/signup", method=GET)
    public String signup(final Model model) {
        return "signup"; // se retorna el nombre de la vista lógica
    }
}
