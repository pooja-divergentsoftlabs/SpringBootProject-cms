package com.divergentsl.springbootproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.springbootproject.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Patient insert(Patient patient) {
		entityManager.persist(patient);
		return patient;
	}

	@Override
	public Patient find(int id) {
		Patient patient = entityManager.find(Patient.class, id);
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		TypedQuery<Patient> query = entityManager.createQuery("Select p from Patient p",Patient.class);
		List<Patient> patients = query.getResultList();
		return patients;
	}

	@Override
	public void remove(int id) {
		Patient patient = entityManager.find(Patient.class, id);
		if(patient!=null) {
			entityManager.remove(patient);
		}
		
	}

}
