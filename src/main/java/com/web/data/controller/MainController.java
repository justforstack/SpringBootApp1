package com.web.data.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/profile")
	public String showProfile(){
		return "Welcome";
	}
//	public String showProfile(Principal p,Model model) 
//	{
//		model.addAttribute("name", p.getName());
//		System.out.println(p.getClass().getName());
//		return "Welcome";
//	}
}
