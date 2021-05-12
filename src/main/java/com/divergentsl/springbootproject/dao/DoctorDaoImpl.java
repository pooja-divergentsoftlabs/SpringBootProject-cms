package com.divergentsl.springbootproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.springbootproject.entity.Doctor;


@Repository
public class DoctorDaoImpl implements DoctorDao<Doctor> {
	
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Doctor insert(Doctor doctor) {
		entityManager.persist(doctor);
		return doctor;
	}

	@Override
	public Doctor find(int id) {
		Doctor doctor=entityManager.find(Doctor.class, id);
		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
		TypedQuery<Doctor> query = entityManager.createQuery("Select d from Doctor d",Doctor.class);
		List<Doctor> doctors = query.getResultList();
		return doctors;
	}

	@Override
	public void remove(int id) {
		Doctor doctor = entityManager.find(Doctor.class, id);
		if(doctor!=null) {
		entityManager.remove(doctor);
		}
		
	}
	

	
}
