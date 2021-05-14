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

import com.divergentsl.springbootproject.entity.Appointment;
import com.divergentsl.springbootproject.service.AppointmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(path="/api/appointment",produces="application/json")
@RestController
@CrossOrigin(origins="*")
public class AppointmentRestController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping("/")
	private ResponseEntity<List<Appointment>> getAll(){
		log.debug("get all appointments");
		List<Appointment> allAppointments = appointmentService.findAllAppointment();
		return new ResponseEntity<>(allAppointments,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{appointmentId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int appointmentId) {
		appointmentService.removeAppointment(appointmentId);

}
	
	@GetMapping("/{appointmentId}")
	private ResponseEntity<Appointment> find(@PathVariable int appointmentId){
		Appointment appointment=appointmentService.findAppointment(appointmentId);
		if(appointment != null) {
			return new ResponseEntity<>(appointment,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Appointment appointment) {
		appointmentService.insertAppointment(appointment);
	}
	
		
	
	
	


}
