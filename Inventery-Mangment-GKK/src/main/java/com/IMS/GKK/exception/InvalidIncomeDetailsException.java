package com.IMS.GKK.exception;

import org.springframework.validation.BindingResult;

public class InvalidIncomeDetailsException extends Exception {
	
	private BindingResult results;

	public InvalidIncomeDetailsException(BindingResult results) {
		super();
		this.results = results;
	}

	public BindingResult getResults() {
		return results;
	}

//	public void setResults(BindingResult results) {
//		this.results = results;
//	}
//	
	
	

}
