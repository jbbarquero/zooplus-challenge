package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josemorenoesteban.zooplus.challenge.service.ExchangeRateAgent;
import com.josemorenoesteban.zooplus.challenge.service.GetExchangeRateResponse;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    public static final String DEFAULT_SOUCE = "USD";
    
    @Autowired private ExchangeRateAgent exchangeAgent;
    
    @RequestMapping(value="/", method=GET)
    public String home(final Model model) {
        model.addAttribute("currencies", exchangeAgent.currencies());
        model.addAttribute("searchs",    exchangeAgent.lastQueries());

        return "index"; 
    }
    
    @RequestMapping(value="/rate", method=GET)
    public String rate(@RequestParam("target") final String target, 
                       final Model model) {
        GetExchangeRateResponse response = exchangeAgent.get(DEFAULT_SOUCE, target);
        
        model.addAttribute("currencies", exchangeAgent.currencies());
        model.addAttribute("searchs",    response.getLatstSearches());
        model.addAttribute("rate",       response.getCurrent());
        
        return "index"; 
    }

    @RequestMapping(value="/signin", method=GET)
    public ModelAndView loginPage(@RequestParam(value="error", required=false) String error,
                                  @RequestParam(value="logout",required=false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }
 
        if (logout != null) {
            model.addObject("message", "Logged out from Challenge successfully.");
        }
 
        model.setViewName("signin");
        return model;
    }
}
