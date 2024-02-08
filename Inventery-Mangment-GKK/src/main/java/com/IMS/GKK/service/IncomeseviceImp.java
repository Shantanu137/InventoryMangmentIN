package com.IMS.GKK.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IMS.GKK.exception.IncomeproductnameNotFoundException;
import com.IMS.GKK.model.Income;
import com.IMS.GKK.repositery.IncomeRepositery;

@Service
public class IncomeseviceImp implements IncomeService {
	
	@Autowired
	private IncomeRepositery incomeRepositery;

	@Override
	public List<Income> getAll() {
		
		return incomeRepositery.findAll();
	}

	@Override
	public Income getById(long productId) {
		return incomeRepositery.findById(productId).orElse(null);
	}

	


	@Override
	public void deleteById(long productId) {
		incomeRepositery.deleteById(productId);

	}

	@Override
	public Income add(Income income) {
		// TODO Auto-generated method stub
		return incomeRepositery.save(income);
	}

	@Override
	public Income update(Income income) {
		// TODO Auto-generated method stub
		return incomeRepositery.save(income);
	}
//
	@Override
	public List<Income> findBypname(String pname){
		List<Income> productname = (List<Income>)incomeRepositery.findBypname(pname);

		if(productname.isEmpty()) {
			throw new IncomeproductnameNotFoundException("Income Not Found");
		}
		return productname;
		
		
	}


}
