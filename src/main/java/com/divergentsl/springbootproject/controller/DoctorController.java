package com.divergentsl.springbootproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.springbootproject.entity.Doctor;
import com.divergentsl.springbootproject.service.DoctorService;

@Controller
@RequestMapping("/doc")
public class DoctorController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DoctorService doctorService;
	
	@GetMapping
	protected ModelAndView showPage() {
		List<Doctor> allDoctors = doctorService.findAllDoctor();
		ModelAndView model = new ModelAndView("doctor"); 
		model.addObject("allDoctors", allDoctors); 
		return model;
	}
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		String doctorName = req.getParameter("name");
		String doctorFees = req.getParameter("fees");
		

		Doctor doctor = new Doctor();
		doctorService.insertDoctor(doctorName, doctorFees);
		return "redirect:/doc";
	

}
	
	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		doctorService.removeDoctor(doctorId);
		
		
		return "redirect:/doc";
	}
	

}
