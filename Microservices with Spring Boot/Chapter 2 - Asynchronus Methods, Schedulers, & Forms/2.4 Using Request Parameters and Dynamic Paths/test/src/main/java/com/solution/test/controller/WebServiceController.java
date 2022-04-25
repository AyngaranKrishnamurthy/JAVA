package com.solution.test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value="/organization/")
public class WebServiceController {
	
	@GetMapping("/info")
	public String myName(@RequestParam(defaultValue="Ayngaran Krishnamurthy") String name) {
		return "<h2>Returned from RequestParameter: <br> Welcome to Spring Boot Demo with <i>"+name+"</i> ! This is an HTTP GET Request </h2>";
	}
	@GetMapping("/info/{name}")
	 public String myName1(@PathVariable(name="name") String name) {
	  
	 return "<h2>Returned from DynamicPath: <br> Welcome to Spring Boot with <i>"+name+"</i> ! This is an HTTP GET Request. </h2>";
	 }
}
 /*
@Controller
@RequestMapping(value="/organization/")
public class WebServiceController {
	
	@GetMapping("/")
	public String formPage() {
		return editName;
	}
	@GetMapping("/info")
	 public String myName(@RequestParam(defaultValue="Ayngaran Krishnamurthy") String name) {
	  
	 return "<h2>Returned from DynamicPath: <br> Welcome to Spring Boot with <i>"+name+"</i> ! This is an HTTP GET Request. </h2>";
	 }
}
*/