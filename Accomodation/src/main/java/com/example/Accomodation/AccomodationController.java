package com.example.Accomodation;

import org.springframework.web.bind.annotation.GetMapping;

public class AccomodationController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/allhostels")
    public String allhostelPage(){
        return "allhostels";
    }
}
