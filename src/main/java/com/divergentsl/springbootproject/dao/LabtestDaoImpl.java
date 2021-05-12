package com.divergentsl.springbootproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.springbootproject.entity.Labtest;


@Repository
public class LabtestDaoImpl implements LabtestDao<Labtest> {
	
	@PersistenceContext
	EntityManager entityManager;
	

	@Override
	public Labtest insert(Labtest labtest) {
		entityManager.persist(labtest);
		return labtest;
	}

	@Override
	public Labtest find(int id) {
		Labtest labtest = entityManager.find( Labtest.class,id);
		return labtest;
	}

	@Override
	public List<Labtest> findAll() {
		TypedQuery<Labtest> query = entityManager.createQuery("Select l from Labtest l",Labtest.class);
		List<Labtest> labtests = query.getResultList();
		return labtests;
		
	}

	@Override
	public void remove(int id) {
		Labtest labtest = entityManager.find( Labtest.class,id);
		if(labtest!=null) {
		entityManager.remove(labtest);
		}
		
	}
	
	

}
