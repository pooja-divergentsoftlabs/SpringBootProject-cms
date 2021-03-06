package com.divergentsl.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootproject.dao.DoctorDao;
import com.divergentsl.springbootproject.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorDao doctorDao;
	

	@Override
	@Transactional
	public Doctor insertDoctor(Doctor doctor) {
		
		doctorDao.insert(doctor);
		return doctor;
	}
	@Override
	@Transactional(readOnly = true)
	public Doctor findDoctor(int id) {
		return  (Doctor)doctorDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Doctor> findAllDoctor() {
		return  doctorDao.findAll();
	}

	@Override
	@Transactional
	public void removeDoctor(int id) {
		doctorDao.remove(id);
	}

	

}
