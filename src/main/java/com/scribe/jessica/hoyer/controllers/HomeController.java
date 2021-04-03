package com.scribe.jessica.hoyer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.services.DocumentService;
import com.scribe.jessica.hoyer.services.FolderService;
import com.scribe.jessica.hoyer.services.UserService;

@Controller
public class HomeController {
	public UserService us;
	public DocumentService ds;
	public FolderService fs;
	
	@Autowired
	public HomeController(UserService userService, FolderService folderService,
			DocumentService ds) {
		this.us = userService;
		this.fs = folderService;
		this.ds = ds;
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
			return "redirect:/success";
		}
		model.addAttribute("loginFailed", "Login failed, please try again.");
		return "login";
	}
	
	@GetMapping("/profile")
	public String showProfile(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		return "profile";
	}
	
	@GetMapping("/directory")
	public String showDirectory(HttpSession session, Model model) {
		
		// if folderList is empty display message
		
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		
		if (folderList != null) {
			model.addAttribute("folderList", folderList);
			return "directory";
		}
		else {
			model.addAttribute("folderList", "Nothing to display.");
			return "directory";
		}
	}
	
	@GetMapping("/doc/{id}")
	public String showDocument(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Document doc = ds.findById(id);
		model.addAttribute("currentDoc", doc);
		
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		return "doc";
	}
	
	@GetMapping("/edit/{id}")
	public String editDocument(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Document doc = ds.findById(id);
		model.addAttribute("currentDoc", doc);
		
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		return "edit";
	}
	
	@PostMapping("/edit")
	public String processDocument(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("doc_id") int id,
			Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		ds.editDocument(title, content, id);
		model.addAttribute("editSuccess", "Document successfully edited");
		return "directory";
	}
	
	@GetMapping("/success")
	public String showSuccess() {
		return "success";
	}
	
	@GetMapping("/logout")
	public String showLogout() {
		return "login";
	}
	
	@PostMapping("/logout")
	public String processLogout(HttpSession session, Model model) {
		session.setAttribute("currentUser", null);
		model.addAttribute("logoutSuccess", "You have successfully logged out");
		return "login";
	}

}
