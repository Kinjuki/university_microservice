package com.example.CourseRegistration.couseregistration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseRegistration {
    @GetMapping("/")
   public String courseRegisterPage(){
    return "register";
   } 
}
