package com.example.Accomodation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class AccountController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }
}
