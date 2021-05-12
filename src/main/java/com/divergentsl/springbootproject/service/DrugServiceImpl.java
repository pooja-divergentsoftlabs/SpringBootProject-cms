package com.divergentsl.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootproject.dao.DrugDao;
import com.divergentsl.springbootproject.entity.Drug;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	DrugDao drugDao;
		
	@Override
	@Transactional
	public void insertDrug(String name, String quantity) {
		Drug drug = new Drug();
		drug.setName(name);
		drug.setQuantity(quantity);
		drugDao.insert(drug);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Drug findDrug(int id) {		
		return (Drug)drugDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Drug> findAllDrug() {
		return drugDao.findAll();
	}

	@Override
	@Transactional
	public void removeDrug(int id) {
		drugDao.remove(id);
		
	}

	

}
