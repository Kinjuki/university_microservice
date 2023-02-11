package com.example.StudentRecords.students;

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
public class StudentRecordsController {
    @GetMapping("/register")
   public String getRegisterPage(){
    return "register";
   }

   @RequestMapping(value = "addstudent", method=RequestMethod.POST)
	public String addCustomer(@RequestParam("name") String name,
	@RequestParam("sex") String sex,
	@RequestParam("dob") String dob,
	@RequestParam("phone_number") String phone_number,
	@RequestParam("email") String email){

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentrecords","root","");
			Statement stmt = con.createStatement();
			
			PreparedStatement pst = con.prepareStatement("insert into students(name,sex,dob,phone_number,email) values(?,?,?,?,?);");
			pst.setString(1, name);
			pst.setString(2, sex);
			pst.setString(3, dob);
			pst.setString(4, phone_number);
			pst.setString(5, email);
			int rowsAffected = pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}

		return "redirect:/register?status=added";
	}

    @GetMapping("/")
	public String getCustomers(Model model) {
		return "allstudents";
	}
}
