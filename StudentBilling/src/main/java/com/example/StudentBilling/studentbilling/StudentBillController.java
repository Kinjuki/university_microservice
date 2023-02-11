package com.example.StudentBilling.studentbilling;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentBillController {
//     @GetMapping("/studentbill")
//    public String getStudentPage(){
//     return "studentbills";
//    }

   @GetMapping("/studentbill")
   public String checkStudentAdmissionStatus() {
    try {
        // Send a request to the student service
        URL url = new URL("http://localhost:7001/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();

        // If the response is 200 OK, the service is on
        if (statusCode == 200) {
            return "studentbills";
        } else {
            return "serviceoff";
        }
    } catch (IOException e) {
        // If an exception is thrown, the service is off
        return "serviceoff";
    }
   }

   @GetMapping("/")
   public String getAllStudentPayment(){
    return "allpayments";
   }

   @RequestMapping(value = "addpayment", method=RequestMethod.POST)
	public String addCustomer(@RequestParam("id") String id,
	@RequestParam("studentname") String studentname,
	@RequestParam("amount") String amount){

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentbill","root","");
			Statement stmt = con.createStatement();
			
			PreparedStatement pst = con.prepareStatement("insert into bills(student_id,studentname,amount) values(?,?,?);");
			pst.setString(1, id);
			pst.setString(2, studentname);
			pst.setString(3, amount);
			int rowsAffected = pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}

		return "redirect:/?status=1";
	}

   //Write function too check student from student admmision service
   //Get student from admission service
}
