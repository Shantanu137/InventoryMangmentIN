package com.IMS.GKK.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IMS.GKK.exception.IncomeNotFoundException;
import com.IMS.GKK.exception.InvalidIncomeDetailsException;
import com.IMS.GKK.model.Income;
import com.IMS.GKK.service.IncomeService;



@RestController
@RequestMapping("income")
public class IncomeController {
	
	@Autowired
	private IncomeService serviceImp;
	
	@GetMapping
	public ResponseEntity<List<Income>> getAll(){
		return new ResponseEntity<List<Income>>(serviceImp.getAll(),HttpStatus.OK);
	}
	
	@PostMapping("/{Id}")
	public ResponseEntity<Income> getByID(@PathVariable("Id") long productId)throws IncomeNotFoundException{
		Income income = serviceImp.getById(productId);
		if(income != null) {
			return new ResponseEntity<Income>(income,HttpStatus.OK);
		}
		else {
			throw new IncomeNotFoundException();
		}
		
	}
//	@PostMapping("/{pname}")
//	public ResponseEntity<Income> getByIDPnameIncome(@PathVariable("pname") String pnmae)throws IncomeNotFoundException{
//		Income income = serviceImp.getByPname(pname);
//		if(income != null) {
//			return new ResponseEntity<Income>(income,HttpStatus.OK);
//		}
//		else {
//			throw new IncomeNotFoundException();
//		}
//		
//	}
	
	@PostMapping("/ame")
	public List<Income> getIncomeBypname(@RequestBody Income income){
		System.out.println(income.getPname());
		return serviceImp.findBypname(income.getPname());
	}

		
	
	@PostMapping("/add")
	public ResponseEntity<Income> addIncome(@RequestBody @Valid Income income ,BindingResult results)throws InvalidIncomeDetailsException{
		if(results.hasErrors()) {
			throw new InvalidIncomeDetailsException(results);
			}
		else {
			income= serviceImp.add(income);
			return new ResponseEntity<Income>(income,HttpStatus.CREATED);
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Income> updateIncome(@RequestBody @Valid Income income ,BindingResult results)throws InvalidIncomeDetailsException{
		if(results.hasErrors()) {
			throw new InvalidIncomeDetailsException(results);
			}
		else {
			income= serviceImp.update(income);
			return new ResponseEntity<Income>(income,HttpStatus.ACCEPTED);
		}
		
	}
	@DeleteMapping("/{Id}")
	public ResponseEntity<Void> deleteIncome(@PathVariable("Id") long productId){
		serviceImp.deleteById(productId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	
}
