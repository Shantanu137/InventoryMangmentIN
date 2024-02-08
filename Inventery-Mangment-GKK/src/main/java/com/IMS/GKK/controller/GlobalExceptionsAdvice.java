package com.IMS.GKK.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.IMS.GKK.exception.IncomeNotFoundException;
import com.IMS.GKK.exception.InvalidIncomeDetailsException;


@RestControllerAdvice
public class GlobalExceptionsAdvice {

	private Logger logger;
	
	public GlobalExceptionsAdvice() {
		this.logger = LoggerFactory.getLogger(this.getClass().getName());
	}
	
	@ExceptionHandler(IncomeNotFoundException.class)
	public ResponseEntity<String> handleIncomeNotFoundException(IncomeNotFoundException exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<String>("No Such Income Is Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidIncomeDetailsException.class)
	public ResponseEntity<String> handleInvalidIncomeDetailsException(InvalidIncomeDetailsException exp){
		logger.error(exp.getMessage(), exp);
		String errMsg = exp.
				getResults().
				getAllErrors().
				stream().
				map(ObjectError::getDefaultMessage).
				reduce((m1,m2)->m1+","+m2).
				orElse("");
		
		return new ResponseEntity<>(errMsg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllOtherException(Exception exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
