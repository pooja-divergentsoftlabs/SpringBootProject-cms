package com.divergentsl.springbootproject.dao;

import java.util.List;

import com.divergentsl.springbootproject.entity.Patient;

public interface PatientDao {

	public Patient insert(Patient patient);

	public Patient find(int id);

	public List<Patient> findAll();

	public void remove(int id);
	
}
