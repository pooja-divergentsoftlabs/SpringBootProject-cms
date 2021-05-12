package com.divergentsl.springbootproject.dao;

import java.util.List;

public interface AppointmentDao<T> {

	public T insert(T appointment);

	public T find(int id);

	public List<T> findAll();

	public void remove(int id);
	
}
