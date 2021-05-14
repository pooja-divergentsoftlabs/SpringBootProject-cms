package com.divergentsl.springbootproject.service;

import java.util.List;

import com.divergentsl.springbootproject.entity.Appointment;

public interface AppointmentService {
	
	public Appointment insertAppointment(Appointment appointment);

	public Appointment findAppointment(int id);

	public List<Appointment> findAllAppointment();

	public void removeAppointment(int id);
	

}
