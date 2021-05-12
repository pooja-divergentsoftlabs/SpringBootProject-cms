package com.divergentsl.springbootproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.springbootproject.entity.Appointment;


@Repository
public class AppointmentDaoImpl implements AppointmentDao<Appointment> {
	
	@PersistenceContext
	EntityManager entityManager;
	

	@Override
	public Appointment insert(Appointment appointment) {
		entityManager.persist(appointment);
		return appointment;
	}

	@Override
	public Appointment find(int id) {
		Appointment appointment = entityManager.find(Appointment.class, id);
		return appointment;
	}

	@Override
	public List<Appointment> findAll() {
		TypedQuery<Appointment> query = entityManager.createQuery("Select a from Appointment a",Appointment.class);
		List<Appointment> appointments = query.getResultList();
		return appointments;
	}

	@Override
	public void remove(int id) {
		Appointment appointment = entityManager.find(Appointment.class, id);
		if(appointment!=null) {
			entityManager.remove(appointment);
		}
		
	}

}
