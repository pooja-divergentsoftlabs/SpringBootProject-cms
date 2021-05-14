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

import com.divergentsl.springbootproject.entity.Labtest;
import com.divergentsl.springbootproject.entity.Patient;
import com.divergentsl.springbootproject.service.LabtestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/api/labtest",produces="application/json")
@CrossOrigin(origins="*")
public class LabtestRestController {
	
	@Autowired
	private LabtestService labtestService;
	
	@GetMapping("/")
	private ResponseEntity<List<Labtest>> getAll(){
		log.debug("get all labtests");
		List<Labtest> allLabtests = labtestService.findAllLabtest();
		return new ResponseEntity<>(allLabtests, HttpStatus.OK);
		
	}
	
	@DeleteMapping("delete/{labtestId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int labtestId) {
		labtestService.removeLabtest(labtestId);
	}
	
	@GetMapping("/{labtestId}")
	private ResponseEntity<Labtest> find(@PathVariable int labtestId){
		Labtest labtest=labtestService.findLabtest(labtestId);
		if(labtest != null) {
			return new ResponseEntity<>(labtest,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Labtest labtest) {
		labtestService.insertLabtest(labtest);
	}
	
	
}
