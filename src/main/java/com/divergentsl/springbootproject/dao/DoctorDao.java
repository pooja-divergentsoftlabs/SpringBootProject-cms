package com.divergentsl.springbootproject.dao;

import java.util.List;
	

public interface DoctorDao<T> {
	
	public T insert(T doctor);
	
	public T find(int id);
	
	public List<T> findAll();
	
	public void remove(int id);
	

}
