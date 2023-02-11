package com.example.StudentAdmission.studentadmission;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

   @GetMapping("/allstudentsrecords")
public String checkStudentServiceStatus() {
    try {
        // Send a request to the student service
        URL url = new URL("http://localhost:7002/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();

        // If the response is 200 OK, the service is on
        if (statusCode == 200) {
            return "allstudent";
        } else {
            return "serviceoff";
        }
    } catch (IOException e) {
        // If an exception is thrown, the service is off
        return "serviceoff";
    }
}
}
