package com.divergentsl.springbootproject.service;

import java.util.List;

import com.divergentsl.springbootproject.entity.Doctor;

public interface DoctorService {
	
	public void insertDoctor(String name, String fees);

	public Doctor findDoctor(int id);

	public List<Doctor> findAllDoctor();

	public void removeDoctor(int id);

}
