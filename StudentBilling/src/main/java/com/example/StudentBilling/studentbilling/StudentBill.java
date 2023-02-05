package com.example.StudentBilling.studentbilling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentBill {
    @GetMapping("/studentbill")
   public String getStudentPage(){
    return "studentbills";
   }
}
