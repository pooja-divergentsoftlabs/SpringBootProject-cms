package com.divergentsl.springbootproject.service;

import java.util.List;

import com.divergentsl.springbootproject.entity.Drug;

public interface DrugService {

	public void insertDrug(String name,String quantity);

	public Drug findDrug(int id);

	public List<Drug> findAllDrug();

	public void removeDrug(int id);
}
