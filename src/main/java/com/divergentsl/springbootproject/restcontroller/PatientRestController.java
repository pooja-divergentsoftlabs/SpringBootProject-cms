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

import com.divergentsl.springbootproject.entity.Patient;
import com.divergentsl.springbootproject.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/api/patient",produces="application/json")
@CrossOrigin(origins="*")
public class PatientRestController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/")
	private ResponseEntity<List<Patient>> getAll(){
		log.debug("get all the patients");
		List<Patient> allPatients = patientService.findAllPatient();
		return new ResponseEntity<>(allPatients,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{patientId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int patientId) {
		patientService.removePatient(patientId);
	}
	
	
	@GetMapping("/{patientId}")
	private ResponseEntity<Patient> find(@PathVariable int patientId){
		Patient patient=patientService.findPatient(patientId);
		if(patient != null) {
			return new ResponseEntity<>(patient,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Patient patient) {
		patientService.insertPatient(patient);
	}
	
	
	

}
