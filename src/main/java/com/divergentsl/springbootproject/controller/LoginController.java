package com.divergentsl.springbootproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static final long serialVersionUID = 1L;
	
	@PostMapping("/admin")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username.equals("root") &&password.equals("root")) {
			ModelAndView modelAndView = new ModelAndView("admin");
			return modelAndView;
		}
		
		else {
			ModelAndView modelAndView = new ModelAndView("index");
			System.out.println("Wrong Username or Password!!!!");
			return modelAndView;
		}
		
		
	

	}

}
