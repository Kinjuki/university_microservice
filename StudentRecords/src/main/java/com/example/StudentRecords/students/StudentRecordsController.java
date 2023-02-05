package com.example.StudentRecords.students;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentRecordsController {
    @GetMapping("/register")
   public String getRegisterPage(){
    return "register";
   }
}
