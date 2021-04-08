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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.scribe.jessica.hoyer.exceptions.UsernameTakenException;
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
	
	// catches users without accounts trying to access pages that require login credentials
	@ExceptionHandler({NullPointerException.class})
	public String nullUserError() {
		return "access-denied";
	}
	
	// show index page
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	// show index page with specified index mapping
	@GetMapping("/index")
	public String showIndex2() {
		return "index";
	}
	
	/* ===== REGISTER METHODS ==== */
	
	// show register page
	@GetMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	// process register - save new user
	// validation checks: blank username, blank password, username already taken,
	// username between 2 and 30 characters, password between 4 and 20 characters
	@PostMapping("/register")
	public String processRegister(Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		if (username.equals("")) {
			model.addAttribute("usernameBlank", "Username cannot be blank");
			return "register";
		}
		if(password.equals("")) {
			model.addAttribute("passwordBlank", "Password cannot be blank");
			return "register";
		}
		if (username.length() < 2 || username.length() > 30) {
			model.addAttribute("usernameLength", "Username must be between 2 and 30 characters");
			return "register";
		}
		if (password.length() < 4 || password.length() > 20) {
			model.addAttribute("passwordLength", "Password must be between 4 and 20 characters");
			return "register";
		}
		else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			try {
				us.saveUser(user);
				return "redirect:/login";
			}
			catch (UsernameTakenException e){
				model.addAttribute("usernameTaken", "Username is already taken");
				return "register";
			}

		}
	}
	
	/* ===== LOGIN METHODS ==== */
	
	// show login page
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	// process login - login user
	// validation checks: correct username and password
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
	
	/* ===== PROFILE METHODS ==== */
	
	// show profile page
	@GetMapping("/profile")
	public String showProfile(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());				
		model.addAttribute("folderList", folderList);
		return "profile";
	}
	
	// show edit-profile page
	@GetMapping("/edit-profile")
	public String editProfile() {
		return "edit-profile";
	}
	
	// process edit-profile - edit current user's username and password
	// validation checks: blank username, blank password, password mismatch,
	// username between 2 and 30 characters, password between 4 and 20 characters,
	// username already taken
	@PostMapping("edit-profile")
	public String processEditProfile(Model model, HttpSession session,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("c-password") String c_password) {
		User user = (User) session.getAttribute("currentUser");
		
		if (username.equals("")) {
			model.addAttribute("usernameBlank", "Username cannot be blank");
			return "edit-profile";
		}
		if (password.equals("") || c_password.equals("")) {
			model.addAttribute("passwordBlank", "Password cannot be blank");
			return "edit-profile";
		}
		if (!password.equals(c_password)) {
			model.addAttribute("passwordMismatch", "Passwords do not match");
			return "edit-profile";
		}
		if (username.length() < 2 || username.length() > 30) {
			model.addAttribute("usernameLength", "Username must be between 2 and 30 characters");
			return "edit-profile";
		}
		if (password.length() < 4 || password.length() > 20) {
			model.addAttribute("passwordLength", "Password must be between 4 and 20 characters");
			return "edit-profile";
		}
		else {
			try {
				us.editProfile(username, password, user.getId());
				model.addAttribute("profileEditSuccess", "Profile updated successfully");
				return "profile";
			}
			catch (UsernameTakenException e){
				model.addAttribute("usernameTaken", "Username is already taken");
				return "edit-profile";
			}
		}
	}
	
	/* ===== DELETE-PROFILE METHODS ==== */
	
	// show delete-profile page
	// directs to confirmation page
	@GetMapping("/delete-profile")
	public String confirmUserDelete() {
		return "delete-profile";
	}
	
	// process delete user - deletes current user
	@PostMapping("/delete-profile")
	public String deleteUser(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		us.deleteUser(user);
		return "redirect:/index";
	}
	
	/* ===== DIRECTORY METHODS ==== */
	
	// show directory page
	@GetMapping("/directory")
	public String showDirectory(Model model, HttpSession session){		
		User user = (User) session.getAttribute("currentUser");
		List<Folder> folderList = fs.listAllFolders(user.getId());				
		model.addAttribute("folderList", folderList);
		return "directory";
	}
	
	// show directory page that displays messages for the changes the user has made
	// currently does not work
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
	
	/* ===== DOC METHODS ==== */
	
	// show doc page aka view mode
	// folders not included because they only contain a title which is already displayed
	// in the organizer
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
	
	/* ===== EDIT METHODS ==== */
	
	// show edit-doc page aka edit mode
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

	// process edit-doc - edit document title, content, folder
	// validation checks: blank title
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
	
	// show edit-folder page
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
	
	// process edit-folder - edit folder title
	// validation checks: blank title
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
	
	/* ===== DELETE METHODS ==== */
	
	// show delete-doc page
	// directs to confirmation page
	@GetMapping("/delete-doc/{id}")
	public String confirmDocDelete(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Document doc = ds.findById(id);
		model.addAttribute("currentDoc", doc);
		
		return "delete-doc";
	}
	
	// process delete doc - deletes current document
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
	
	// show delete-folder page
	// directs to confirmation page
	@GetMapping("/delete-folder/{id}")
	public String confirmFolderDelete(@PathVariable("id") int id, Model model,
			HttpSession session) {
		Folder folder = fs.findById(id);
		model.addAttribute("currentFolder", folder);
		
		return "delete-folder";
	}
	
	// process delete folder - deletes current folder
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
	
	/* ===== CREATE METHODS ==== */
	
	// show create-folder page
	@GetMapping("/create-folder")
	public String showCreateFolder(Model model) {
		model.addAttribute("newFolder", new Folder());
		return "create-folder";
	}
	
	// process create folder - creates new folder under user
	// validation check: blank title
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
	
	// show create-doc page
	@GetMapping("/create-doc")
	public String showCreateDoc(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		
		List<Folder> folderList = fs.listAllFolders(user.getId());
		model.addAttribute("folderList", folderList);
		
		return "create-doc";
	}
	
	// process create doc - creates new document under folder (and thereby under user)
	// validation check: blank title, must create folder before creating document (*this
	// check is done in the jsp)
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
		else {
			ds.saveDocument(doc);
			model.addAttribute("docCreate", "true");
			return "redirect:/directory";
		}
		
	}
	
	/* ===== LOGOUT METHODS ==== */
	
	// display logout page
	// logs out current user and sets session to null
	@GetMapping("/logout")
	public String showLogout(HttpSession session, Model model) {
		session.setAttribute("currentUser", null);
		model.addAttribute("logoutSuccess", "true");
		return "redirect:/login";
	}
}
