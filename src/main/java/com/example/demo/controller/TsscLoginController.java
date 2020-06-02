package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TsscLoginController {

	@GetMapping("/login")
	  public String login() {
	    return "login";
	  }

	  // Login form with error
	  @GetMapping("/access-denied")
	  public String loginError(Model model) {
	    return "/error/access-denied";
	  }
}
