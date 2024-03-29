package com.handier.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	   public String welcomePage(Model model) {
	       model.addAttribute("title", "Welcome");
	       model.addAttribute("message", "This is welcome page!");
	       return "welcomePage";
	   }
	@RequestMapping(value = { "/welcome1" }, method = RequestMethod.GET)
	   public String welcomePage1(Model model) {
	       model.addAttribute("title", "Welcome");
	       model.addAttribute("message", "This is welcome page!");
	       return "defaultLayout";
	   }
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	   @RequestMapping(value = "/admin", method = RequestMethod.GET)
	   public String adminPage(Model model) {
	       return "body";
	   }
	 
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	   public String loginPage(Model model ) {
	        
	       return "loginPage";
	   }
	 
	   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	   public String logoutSuccessfulPage(Model model) {
	       model.addAttribute("title", "Logout");
	       return "logoutSuccessfulPage";
	   }
	 
	   @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	   public String userInfo(Model model, Principal principal) {
	 
	       // After user login successfully.
//	       String userName = principal.getName();
	 
//	       System.out.println("User Name: "+ userName);
//	 
	       return "userInfoPage";
	   }
	 
	   @RequestMapping(value = "/403", method = RequestMethod.GET)
	   public String accessDenied(Model model, Principal principal) {
	        
	       if (principal != null) {
	           model.addAttribute("message", "Hi " + principal.getName()
	                   + "<br> You do not have permission to access this page!");
	       } else {
	           model.addAttribute("message",
	                   "You do not have permission to access this page!");
	           
	       }
	       return "403Page";
	   }
}
