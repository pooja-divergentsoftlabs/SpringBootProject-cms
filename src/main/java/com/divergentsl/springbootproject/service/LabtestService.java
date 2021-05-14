package com.divergentsl.springbootproject.service;

import java.util.List;

import com.divergentsl.springbootproject.entity.Labtest;

public interface LabtestService {
	
	public Labtest insertLabtest(Labtest labtest);

	public Labtest findLabtest(int id);

	public List<Labtest> findAllLabtest();

	public void removeLabtest(int id);
	

}
