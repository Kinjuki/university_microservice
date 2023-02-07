package com.example.CourseRegistration.couseregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseRegistration {
    @GetMapping("/")
   public String courseRegisterPage(){
    return "register";
   } 

   @RequestMapping(value = "addcourse", method=RequestMethod.POST)
	public String addCustomer(@RequestParam("name") String name,
	@RequestParam("code") String code,
	@RequestParam("department") String department){

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courseregistration","root","");
			Statement stmt = con.createStatement();
			
			PreparedStatement pst = con.prepareStatement("insert into courses(name,code,department) values(?,?,?);");
			pst.setString(1, name);
			pst.setString(2, code);
			pst.setString(3, department);
			int rowsAffected = pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}

		return "redirect:/";
		
	}


    @GetMapping("/courses")
	public String getCourses(Model model) {
		return "allcourses";
	}
}
