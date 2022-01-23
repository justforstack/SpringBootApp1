package com.web.data.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.data.impl.IUserService;
import com.web.data.impl.UserAlreadyExistException;
import com.web.data.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
//	@Autowired
//	private UserRepository repo;
	//1)show register page
	@GetMapping("/reg")
	public String showReg() {
		return "UserRegister";
	}
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user,
			Model model) throws Exception {
		 String em=user.getEmail();
		 boolean b=service.exists(em);
		 if(b==true) {
				String msg="User with"+em+"alreay exists in db";
			 model.addAttribute("message",msg);
				System.out.println("the msg is"+msg);
//				throw new UserAlreadyExistException(msg);
//             throw new Exception("User with "+em+"  already exists");
         }
		 else {
			 Integer id=service.saveUser(user);

				
				String msg="User" +' '+id+' '+"saved";
				model.addAttribute("message",msg);
				System.out.println("the msg is"+msg);
		 }
			return "UserRegister";
	}
	@GetMapping("/login")
	public String showLoginPage() {
		return "Login";
	}
//	@GetMapping("/home")
//	public String showHome() {
//		return "Welcome";
//	}
	
}
//1)show register page
//2)read from data for save operation}
