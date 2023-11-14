package com.nlb.loanservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = LoanAlreadyExists.class)
	public ResponseEntity<Object> loanAlreadyExist(LoanAlreadyExists alreadyException){
		return new ResponseEntity<Object>(alreadyException.getMsg(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = LoanNotFound.class)
	public ResponseEntity<Object> loanNotFound(LoanNotFound notFoundException){
		return new ResponseEntity<Object>(notFoundException.getMsg(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = LoanGrantLimit.class)
	public ResponseEntity<Object> loanGrantLimit(LoanGrantLimit loanLimitException){
		return new ResponseEntity<Object>(loanLimitException.getMsg(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = LoanBlankField.class)
	public ResponseEntity<Object> validationException(LoanBlankField exception){
		return new ResponseEntity<Object>(exception.getMsg(), HttpStatus.BAD_REQUEST);
	}
}
