package com.example.StudentAdmission.studentadmission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentAdmissionController {

    @GetMapping("/")
   public String homePage(){
    return "home";
   } 

   @GetMapping("/register")
   public String registerPage(){
    return "register";
   }

   @GetMapping("/login")
   public String loginPage(){
    return "login";
   }
}
