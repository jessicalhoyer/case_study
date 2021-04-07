package com.scribe.jessica.hoyer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
//@Validated
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
			return "redirect:/directory";
		}
		model.addAttribute("loginFailed", "Login failed, please try again.");
		return "login";
	}
	
	@GetMapping("/profile")
	public String showProfile(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		return "profile";
	}
	
	@GetMapping("/edit-profile/{id}")
	public String editProfile(@PathVariable("id") int id, Model model) {
		
		// not finished
		
		return "profile";
	}
	
	@PostMapping("edit-profile")
	public String processEditProfile(Model model) {
		
		// not finished
		
		model.addAttribute("profileEditSuccess", "Profile updated successfully");
		return "profile";
	}
	
	@GetMapping("/delete-profile")
	public String confirmUserDelete() {
		return "delete-profile";
	}
	
	@PostMapping("/delete-profile")
	public String deleteUser(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		us.deleteUser(user);
		return "index";
	}
	
	@GetMapping("/directory")
	public String showDirectory(Model model, HttpSession session){
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
	
	@GetMapping("/directory{message}")
	public String showDirectoryMessage(@PathVariable("message") String message,
			HttpSession session, Model model) {
		
		if (message.equals("?folderCreate=true")) {
			model.addAttribute("folderCreateSuccess", "Folder created successfully.");
		}
		if (message.equals("?folderEdit=true")) {
			model.addAttribute("folderEditSuccess", "Folder edited successfully ");
		}
		if (message.equals("?folderDelete=true")) {
			model.addAttribute("folderDeleteSuccess", "Folder deleted successfully.");
		}
		if (message.equals("?docCreate=true")) {
			model.addAttribute("docCreateSuccess", "Document created successfully.");
		}
		if (message.equals("?docEdit=true")) {
			model.addAttribute("docEditSuccess", "Document edited successfully.");
		}
		if (message.equals("?docDelete=true")) {
			model.addAttribute("docDeleteSuccess", "Document deleted successfully.");
		}
		
		
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		return "directory";
		
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
	
	@GetMapping("/edit-doc/{id}")
	public String editDocument(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Document doc = ds.findById(id);
		model.addAttribute("currentDoc", doc);
		
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		return "edit-doc";
	}

	@PostMapping("/edit-doc")
	public String processDocument(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("folder") String folderId,
			@RequestParam("id") int id,
			Model model, HttpSession session) {
		
		if (!title.equals("")) {
			Folder folder = fs.findById(Integer.parseInt(folderId));
			ds.editDocument(title, content, folder, id);
			model.addAttribute("docEdit", "true");
			return "redirect:/directory";
		}
		else {
			Document doc = ds.findById(id);
			model.addAttribute("currentDoc", doc);
			
			User user = (User) session.getAttribute("currentUser");
			List<Folder> folderList = fs.listAllFolders(user.getId());
			model.addAttribute("folderList", folderList);
			
			model.addAttribute("titleBlank", "Title cannot be blank");
			return "edit-doc";
		}
	}
	
	
	@GetMapping("/edit-folder/{id}")
	public String editFolder(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Folder folder = fs.findById(id);
		model.addAttribute("currentFolder", folder);
		
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		return "edit-folder";
	}
	
	@PostMapping("/edit-folder")
	public String processFolder(Model model, HttpSession session,
			@RequestParam("title") String title,
			@RequestParam("id") String id) {
		
		if (!title.equals("")) {

			fs.editFolder(title, Integer.parseInt(id));
			model.addAttribute("folderEditSuccess", "Folder successfully edited");
			return "redirect:/directory";
		}
		else {
			Folder folder = fs.findById(Integer.parseInt(id));
			model.addAttribute("currentFolder", folder);
			
			User user = (User) session.getAttribute("currentUser");
			List<Folder> folderList = fs.listAllFolders(user.getId());
			model.addAttribute("folderList", folderList);
			
			model.addAttribute("titleBlank", "Title cannot be blank");
			return "edit-folder";
		}
		
	}
	
	@GetMapping("/delete-doc/{id}")
	public String confirmDocDelete(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Document doc = ds.findById(id);
		model.addAttribute("currentDoc", doc);
		
		return "delete-doc";
	}
	
	@PostMapping("/delete-doc")
	public String deleteDoc(@RequestParam("doc_id") int id,
			Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		ds.deleteDocument(id);
		model.addAttribute("docDeleteSuccess", "Document deleted successfully");
		return "redirect:/directory";
	}
	
	@GetMapping("/delete-folder/{id}")
	public String confirmFolderDelete(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Folder folder = fs.findById(id);
		model.addAttribute("currentFolder", folder);
		
		return "delete-folder";
	}
	
	@PostMapping("/delete-folder")
	public String deleteFolder(@RequestParam("folder_id") int id,
			Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		fs.deleteFolder(id);
		model.addAttribute("folderDelete", "true");
		return "redirect:/directory";
	}
	
	@GetMapping("/create-folder")
	public String showCreateFolder(Model model) {
		model.addAttribute("newFolder", new Folder());
		return "create-folder";
	}
	
	@PostMapping("/create-folder")
	public String processCreateFolder(@Valid @ModelAttribute("newFolder") Folder folder,
			BindingResult result, Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("currentUser");
		folder.setUser(user);
		
		if (result.hasErrors()) {
			return "create-folder";
		}
		else {
			List<Folder> folderList = fs.listAllFolders(user.getId());
			model.addAttribute("folderList", folderList);
			fs.saveFolder(folder);
			model.addAttribute("folderCreate", "true");
			return "redirect:/directory";
			
		}
	}
	
	@GetMapping("/create-doc")
	public String showCreateDoc(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		return "create-doc";
	}
	
	@PostMapping("/create-doc")
	public String processCreateDoc(Model model, HttpSession session,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("folder") String folderId) {
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		Document doc = new Document();
		doc.setFold(fs.findById(Integer.parseInt(folderId)));
		doc.setTitle(title);
		doc.setContent(content);
		
		if (title.equals("")) {
			model.addAttribute("titleBlank", "Title cannot be blank");
			return "create-doc";
		}
		else if (folderId.equals("")) {
			model.addAttribute("folderBlank", "Please create a folder before creating a document.");
			return "create-doc";
		}
		else {
			ds.saveDocument(doc);
			model.addAttribute("docCreate", "true");
			return "redirect:/directory";
		}
		
	}
	
	
	@GetMapping("/success")
	public String showSuccess() {
		return "success";
	}
	
	@GetMapping("/logout")
	public String showLogout(HttpSession session, Model model) {
		session.setAttribute("currentUser", null);
		model.addAttribute("logoutSuccess", "true");
		return "redirect:/login";
	}
}
