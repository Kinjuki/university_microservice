package com.example.programservice;

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
public class ProgramController {
    @GetMapping("/")
   public String programRegisterPage(){
    return "register";
   } 

   @RequestMapping(value = "addprogram", method=RequestMethod.POST)
	public String addProgram(@RequestParam("name") String name,
	@RequestParam("dapartment") String dapartment,
	@RequestParam("facult") String facult){

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/programregistration","root","");
			Statement stmt = con.createStatement();
			PreparedStatement pst = con.prepareStatement("insert into programs(name,department,facult) values(?,?,?);");
			pst.setString(1, name);
			pst.setString(2, dapartment);
			pst.setString(3, facult);
			int rowsAffected = pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}

		return "redirect:/";
		
	}


    @GetMapping("/programs")
	public String getCourses(Model model) {
		return "allprograms";
	}
}
