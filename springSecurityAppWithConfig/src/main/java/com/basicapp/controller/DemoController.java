package com.basicapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/showproducts")
	public String showproducts() {
		return "Show all products";
	}
	
	@GetMapping("/showoffers")
	public String showoffers() {
		return "Show all offers";
	}
	
	@GetMapping("/makepurchase")
	public String makepurchase() {
		return "Product purchased successfully";
	}
	
	@GetMapping("/userprofile")
	public String userprofile() {
		return "Show user profile";
	}
	
	@GetMapping("/addnewproduct")
	public String addnewproduct() {
		return "New product added successfully";
	}
	
	
}
