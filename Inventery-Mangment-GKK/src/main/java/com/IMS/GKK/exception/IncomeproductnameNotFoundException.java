package com.IMS.GKK.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncomeproductnameNotFoundException extends RuntimeException {
	public IncomeproductnameNotFoundException (String message) {
		super(message);
	}
	
	

}
