package com.IMS.GKK.service;

import java.util.List;

import com.IMS.GKK.exception.IncomeNotFoundException;
import com.IMS.GKK.model.Income;

public interface IncomeService {
	
	List<Income> getAll();
	Income getById(long productId);
	Income add(Income income );
	Income update(Income income);
	void deleteById(long productId);
	public List<Income> findBypname(String pname);


}
