package com.divergentsl.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootproject.dao.PatientDao;
import com.divergentsl.springbootproject.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;
	
	

	@Override
	@Transactional(readOnly = true)
	public Patient findPatient(int id) {
		return  (Patient)patientDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Patient> findAllPatient() {
		return patientDao.findAll();
	}

	@Override
	@Transactional
	public void removePatient(int id) {
		patientDao.remove(id);
		
	}

	@Override
	@Transactional
	public void insertPatient(Patient patient) {
		patientDao.insert(patient);
	}

	/*
	 * @Override
	 * 
	 * @Transactional public void insertPatient(String name,String address, String
	 * contactnumber) { Patient patient=new Patient(); patient.setName(name);
	 * patient.setAddress(address); patient.setContactnumber(contactnumber);
	 * patientDao.insert(patient);
	 * 
	 * 
	 * }
	 */
	
}
