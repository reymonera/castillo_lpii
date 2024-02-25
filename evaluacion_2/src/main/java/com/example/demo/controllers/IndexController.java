package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prueba")
public class IndexController {

	@GetMapping("/index")
	public String showIndex() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(String usuario, String pass) {
		// modelo - bd 
		return "home - error";
	}
	
}
