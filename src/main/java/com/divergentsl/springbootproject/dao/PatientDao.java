package com.divergentsl.springbootproject.dao;

import java.util.List;

public interface PatientDao<T> {

	public T insert(T patient);

	public T find(int id);

	public List<T> findAll();

	public void remove(int id);
	
}
