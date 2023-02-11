package com.example.Accomodation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AccomodationController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/allaccomodation")
    public String checkStudentAdmissionStatus() {
        try {
            // Send a request to the student service
            URL url = new URL("http://localhost:7001/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int statusCode = connection.getResponseCode();
    
            // If the response is 200 OK, the service is on
            if (statusCode == 200) {
                return "addaccomodation";
            } else {
                return "serviceoff";
            }
        } catch (IOException e) {
            // If an exception is thrown, the service is off
            return "serviceoff";
        }
       }

       @GetMapping("/add/{id}/{name}")
       public String addAccomodation(@PathVariable Long id, 
       @PathVariable String name){
        try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accomodation","root","");
			Statement stmt = con.createStatement();
			PreparedStatement pst = con.prepareStatement("insert into accomodations(student_id,studentname,hostel) values(?,?,?);");
			pst.setLong(1,id);
			pst.setString(2, name);
            pst.setString(3, "Mkwawa");
			int rowsAffected = pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
        return "redirect:/allaccomodation?status=1";
       }
}
