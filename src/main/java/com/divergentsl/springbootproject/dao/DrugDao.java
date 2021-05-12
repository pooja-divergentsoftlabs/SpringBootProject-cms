package com.divergentsl.springbootproject.dao;

import java.util.List;

public interface DrugDao<T> {
	
	public T insert(T drug);
	
	public T find(int id);
	
	public List<T> findAll();
	
	public void remove(int id);

}
