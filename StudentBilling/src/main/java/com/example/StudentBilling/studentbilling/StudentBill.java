package com.example.StudentBilling.studentbilling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentBill {
    @GetMapping("/studentbill")
   public String getStudentPage(){
    return "studentbills";
   }

   //Write function too check student from student admmision service
   //Get student from admission service

   

}
