package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josemorenoesteban.zooplus.challenge.service.ExchangeRateAgent;
import com.josemorenoesteban.zooplus.challenge.service.GetExchangeRateResponse;

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
    public String loginPage(@RequestParam(value="error", required=false) String error,
                            @RequestParam(value="logout",required=false) String logout,
                            final Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid Credentials provided.");
        }
 
        if (logout != null) {
            model.addAttribute("message", "Logged out from Challenge successfully.");
        }
        return "signin";
    }

    @RequestMapping(value="/signup", method=POST)
    public String signup(@RequestParam(value="firstname",  required=false) String firstname,
                         @RequestParam(value="lastname",   required=false) String lastname,
                         @RequestParam(value="email",      required=false) String email,
                         @RequestParam(value="bday",       required=false) String bday,
                         @RequestParam(value="password",   required=false) String password,
                         @RequestParam(value="repassword", required=false) String repassword,
                         final Model model) {

        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.printf("firstname=%s\n", firstname);
        System.out.printf("lastname=%s\n", lastname);
        System.out.printf("email=%s\n", email);
        System.out.printf("dbay=%s\n", bday);
        System.out.printf("password=%s\n", password);
        System.out.printf("repassword=%s\n", repassword);
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        
        return "index";
    }
}
