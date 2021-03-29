package com.scribe.jessica.hoyer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.services.DocumentService;
import com.scribe.jessica.hoyer.services.FolderService;
import com.scribe.jessica.hoyer.services.UserService;

@Controller
@SessionAttributes("userkey")
public class HomeController {
	UserService us = new UserService();
//	DocumentService ds = new DocumentService();
//	FolderService fs = new FolderService();
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/index")
	public String showIndex2() {
		return "index";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@ModelAttribute("userkey")
	@PostMapping("/login")
	public String processLogin(@ModelAttribute("user") User user) {
		System.out.println(user.toString());
		if (us.loginUser(user)) {
			return "success";
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/register")
	public String showRegister() {
		return "register";
	}

}
