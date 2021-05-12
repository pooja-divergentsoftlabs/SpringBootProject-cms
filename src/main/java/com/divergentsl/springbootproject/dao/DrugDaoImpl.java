package com.divergentsl.springbootproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.springbootproject.entity.Drug;


@Repository
public class DrugDaoImpl implements DrugDao<Drug>{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Drug insert(Drug drug) {
		entityManager.persist(drug);
		return drug;
	}

	@Override
	public Drug find(int id) {
		Drug drug = entityManager.find(Drug.class, id);
		return drug;
		
	}

	@Override
	public List<Drug> findAll() {
		TypedQuery<Drug> query = entityManager.createQuery("Select e from Drug e",Drug.class);
		List<Drug> drugs = query.getResultList();
		return drugs;
	}

	@Override
	public void remove(int id) {
		Drug drug = entityManager.find(Drug.class, id);
		if(drug!=null) {
			entityManager.remove(drug);
		}
		
	}
	

}
