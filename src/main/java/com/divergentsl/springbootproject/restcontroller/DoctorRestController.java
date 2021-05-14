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

import com.divergentsl.springbootproject.entity.Doctor;
import com.divergentsl.springbootproject.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(path="/api/doctor",produces="application/json")
@RestController
@CrossOrigin(origins="*")
public class DoctorRestController {
	
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/")
	private ResponseEntity<List<Doctor>> getAll(){
		log.debug("get all drugs");
		List<Doctor> allDoctors = doctorService.findAllDoctor();
		return new ResponseEntity<>(allDoctors,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{doctorId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int doctorId) {
		doctorService.removeDoctor(doctorId);

}
	
	@GetMapping("/{doctorId}")
	private ResponseEntity<Doctor> find(@PathVariable int doctorId){
		Doctor doctor=doctorService.findDoctor(doctorId);
		if(doctor != null) {
			return new ResponseEntity<>(doctor,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		
	}
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Doctor doctor) {
		doctorService.insertDoctor(doctor);
	}
}
