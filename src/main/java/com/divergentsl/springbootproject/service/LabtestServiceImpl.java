package com.divergentsl.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootproject.dao.LabtestDao;
import com.divergentsl.springbootproject.entity.Labtest;

@Service
public class LabtestServiceImpl implements LabtestService {
	
	@Autowired
	LabtestDao labtestDao;
	

	@Override
	@Transactional
	public void insertLabtest(String name, String patientname) {
		Labtest labtest = new Labtest();
		labtest.setName(name);
		labtest.setPatientname(patientname);
		labtestDao.insert(labtest);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Labtest findLabtest(int id) {
				return (Labtest)labtestDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Labtest> findAllLabtest() {
		return labtestDao.findAll();
	}

	@Override
	@Transactional
	public void removeLabtest(int id) {
		labtestDao.remove(id);
		
	}

	

}
