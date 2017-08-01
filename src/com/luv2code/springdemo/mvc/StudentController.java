package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@RequestMapping("/new")
	public String showForm(Model theModel) {
		//create student object
		Student theStudent = new Student();
		// add student object to model
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("countryOptions", countryOptions);
		return "student/new";
	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("student") Student theStudent) {
		System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student/student-confirmation";
	}
	
}
