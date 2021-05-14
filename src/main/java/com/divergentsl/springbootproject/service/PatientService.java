package com.divergentsl.springbootproject.service;

import java.util.List;

import com.divergentsl.springbootproject.entity.Patient;


public interface PatientService {
	
	//public void insertPatient(String name,String address, String contactnumber);

	public Patient findPatient(int id);

	public List<Patient> findAllPatient();

	public void removePatient(int id);

	public void insertPatient(Patient patient);
	

}
