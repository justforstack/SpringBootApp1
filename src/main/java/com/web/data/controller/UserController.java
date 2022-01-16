package com.web.data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.data.impl.IUserService;
import com.web.data.model.User;

@Controller
public class UserController {
	@Autowired
	private IUserService service;
	//1)show register page
	@GetMapping("/reg")
	public String showReg() {
		return "UserRegister";
	}
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user,
			Model model) {
		Integer id=service.saveUser(user);
		String msg="User" +' '+id+' '+"saved";
		model.addAttribute("message"+msg);
		return "UserRegister";
		
	}
	
}
//1)show register page
//2)read from data for save operation}
