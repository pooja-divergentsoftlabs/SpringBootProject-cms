package com.divergentsl.springbootproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.springbootproject.entity.Appointment;
import com.divergentsl.springbootproject.service.AppointmentService;

@Controller
@RequestMapping("/app")
public class AppointmentController {
	
private static final long serialVersionUID = 1L;
	
	@Autowired
	AppointmentService appointmentService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	
	@GetMapping
	protected ModelAndView showPage() {
		List<Appointment> allAppointments = appointmentService.findAllAppointment();
		ModelAndView model = new ModelAndView("appointment"); 
		model.addObject("allAppointments", allAppointments); 
		return model;
	}
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		String appointmentName = req.getParameter("name");
		String appointmentDate = req.getParameter("date");
		
		

		Appointment appointment = new Appointment();
		appointmentService.insertAppointment(appointmentName, appointmentDate);
				
		return "redirect:/app";
	

}
	
	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int appointmentId = Integer.parseInt(req.getParameter("appointmentId"));
		appointmentService.removeAppointment(appointmentId);
		
		
		return "redirect:/app";
	}
	
	
	

}
