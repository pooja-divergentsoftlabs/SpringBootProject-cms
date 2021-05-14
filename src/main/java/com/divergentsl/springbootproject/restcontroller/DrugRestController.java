package com.divergentsl.springbootproject.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.springbootproject.entity.Drug;
import com.divergentsl.springbootproject.service.DrugService;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(path="/api/drug",produces="application/json")
@CrossOrigin(origins="*")
public class DrugRestController {
	
	
	@Autowired
	private DrugService drugService;
	
	@GetMapping("/")
	private ResponseEntity<List<Drug>> getAll(){
		log.debug("get all drugs");
		List<Drug> allDrugs = drugService.findAllDrug();
		return new ResponseEntity<>(allDrugs, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{drugId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int drugId) {
		drugService.removeDrug(drugId);
	}
	
	@GetMapping("/{drugId}")
	private ResponseEntity<Drug> find(@PathVariable int drugId){
		Drug drug=drugService.findDrug(drugId);
		if(drug != null) {
			return new ResponseEntity<>(drug,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Drug drug) {
		drugService.insertDrug(drug);
	}

}


