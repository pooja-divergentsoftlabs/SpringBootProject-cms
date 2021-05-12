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


import com.divergentsl.springbootproject.entity.Patient;
import com.divergentsl.springbootproject.service.PatientService;

@Controller
@RequestMapping("/pnt")
public class PatientController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	PatientService patientService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	
	@GetMapping
	protected ModelAndView showPage() {
		List<Patient> allPatients = patientService.findAllPatient();
		ModelAndView model = new ModelAndView("patient"); 
		model.addObject("allPatients", allPatients); 
		return model;
	}
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		String patientName = req.getParameter("name");
		String patientAddress = req.getParameter("address");
		String patientContactnumber = req.getParameter("contactnumber");
		

		Patient patient = new Patient();
		patientService.insertPatient(patientName, patientAddress, patientContactnumber);
				
		return "redirect:/pnt";
	

}
	
	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int patientId = Integer.parseInt(req.getParameter("patientId"));
		patientService.removePatient(patientId);
		
		
		return "redirect:/pnt";
	}
	
}
