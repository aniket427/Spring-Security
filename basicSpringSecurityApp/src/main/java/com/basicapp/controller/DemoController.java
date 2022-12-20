package com.basicapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/welcome")
	public String welcomeStr() {
		return "Spring application with Security";
	}
}
