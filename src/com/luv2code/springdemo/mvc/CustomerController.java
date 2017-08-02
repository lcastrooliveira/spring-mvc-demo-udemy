package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/new")
	public String newCustomer(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer/new";
	}
	
	@RequestMapping("/create")
	public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "customer/new";
		else
			return "customer/confirmation";
	}
}
