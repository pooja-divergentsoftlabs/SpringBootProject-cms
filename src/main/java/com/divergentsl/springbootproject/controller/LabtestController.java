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

import com.divergentsl.springbootproject.entity.Labtest;
import com.divergentsl.springbootproject.service.LabtestService;

@Controller
@RequestMapping("/lab")
public class LabtestController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	LabtestService labtestService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	
	
	@GetMapping
	protected ModelAndView showPage() {
		List<Labtest> allLabtests= labtestService.findAllLabtest();
		ModelAndView model = new ModelAndView("labtest"); 
		model.addObject("allLabtests", allLabtests); 
		return model;
	}
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String labtestName = req.getParameter("name");
		String labtestPatientname = req.getParameter("patientname");
		

		Labtest labtest = new Labtest();
		labtestService.insertLabtest(labtestName, labtestPatientname);
				
		return "redirect:/lab";
	

}
	
	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int labtestId = Integer.parseInt(req.getParameter("labtestId"));
		labtestService.removeLabtest(labtestId);
		
		
		return "redirect:/lab";
	}
	

}
