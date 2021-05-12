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

import com.divergentsl.springbootproject.entity.Drug;
import com.divergentsl.springbootproject.service.DrugService;

@Controller
@RequestMapping("/drug")
public class DrugController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DrugService drugService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	
	@GetMapping
	protected ModelAndView showPage() {
		List<Drug> allDrugs = drugService.findAllDrug();
		ModelAndView model = new ModelAndView("drug"); 
		model.addObject("allDrugs", allDrugs); 
		return model;
	}
	
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		String drugName = req.getParameter("name");
		String drugQuantity = req.getParameter("quantity");
		

		Drug drug = new Drug();
		drugService.insertDrug(drugName, drugQuantity);
				
		return "redirect:/drug";
	

}
	
	
	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int drugId = Integer.parseInt(req.getParameter("drugId"));
		drugService.removeDrug(drugId);
		
		
		return "redirect:/drug";
	}

}
