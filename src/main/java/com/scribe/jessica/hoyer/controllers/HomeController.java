package com.scribe.jessica.hoyer.controllers;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.services.DocumentService;
import com.scribe.jessica.hoyer.services.FolderService;
import com.scribe.jessica.hoyer.services.UserService;

@Controller
public class HomeController {
	public UserService us;
//	DocumentService ds = new DocumentService();
//	FolderService fs = new FolderService();
	
	@Autowired
	public HomeController(UserService userService) {
		this.us = userService;
	}
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/index")
	public String showIndex2() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		else {
			us.saveUser(user);
			return "redirect:/login";
		}
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model, HttpSession session) {
		User user = us.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			session.setAttribute("currentUser", user);
			return "success";
		}
		model.addAttribute("loginFailed", "Login failed, please try again.");
		return "login";
	}
	
	@GetMapping("/success")
	public String showSuccess() {
		return "success";
	}

}
