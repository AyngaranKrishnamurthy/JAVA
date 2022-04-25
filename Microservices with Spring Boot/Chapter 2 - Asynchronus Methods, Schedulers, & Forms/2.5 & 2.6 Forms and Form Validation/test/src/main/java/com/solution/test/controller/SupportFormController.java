package com.solution.test.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;

import com.solution.model.SupportForm;

@Controller
public class SupportFormController {
	
	@GetMapping("/support")
	public String complaintForm(Model model) {
		
		model.addAttribute("supportDetails", new SupportForm());
		
		List<String> membershipList = Arrays.asList("Silver","Gold","Platinum");
		model.addAttribute("membershipList", membershipList);
		return "support";
	}
	@PostMapping("/support")
	 public String submitComplaint(@Valid @ModelAttribute("supportDetails") SupportForm supportDetails, BindingResult bindingResult, Model model) {
		List<String> membershipList = Arrays.asList("Silver","Gold","Platinum");
		model.addAttribute("membershipList", membershipList);
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("Errors Found!");
			return "support";
		}
		System.out.println("No Errors Found");
	  
	 return "submit";
	 }
}
