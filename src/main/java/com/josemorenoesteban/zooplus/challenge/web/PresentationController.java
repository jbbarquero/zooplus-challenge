package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PresentationController {
    
    @RequestMapping(value="/presentation", method=GET)
    public String presentation() {
        return "presentation/index"; 
    }
}
