package com.nlb.loanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nlb.loanservice.entity.LoanApplication;
import com.nlb.loanservice.exception.LoanAlreadyExists;
import com.nlb.loanservice.exception.LoanBlankField;
import com.nlb.loanservice.exception.LoanGrantLimit;
import com.nlb.loanservice.exception.LoanNotFound;
import com.nlb.loanservice.service.LoanApplicationServiceImpl;

@RestController
public class LoanApplicationController {

	@Autowired
	LoanApplicationServiceImpl serviceImpl;

	@RequestMapping(value = "/applyloan", method= {RequestMethod.POST})
	public ResponseEntity<Object> applyLoan(@RequestBody LoanApplication loanApp) {
		try {

			return new ResponseEntity<Object>(serviceImpl.saveLoanApplication(loanApp), HttpStatus.OK);

		} catch (LoanAlreadyExists e) {

			throw new LoanAlreadyExists("Loan Is Already Issued to this Id.");

		} catch (LoanGrantLimit e) {

			throw new LoanGrantLimit("LoanAmount must be between 1000 to 2000000.");

		} catch (LoanBlankField e) {

			throw new LoanBlankField("Fields Should not be empty");
		}
	}

	@GetMapping(value = "/approveloan/{id}")
	public ResponseEntity<Object> approveLoan(@PathVariable int id) {
		try {
			return new ResponseEntity<Object>(serviceImpl.approveLoanApplication(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new LoanNotFound("No loan issued to this id.");
		}

	}

	@GetMapping(value = "/rejectloan/{id}")
	public ResponseEntity<Object> rejectLoan(@PathVariable int id) {
		try {
			return new ResponseEntity<Object>(serviceImpl.rejectLoanApplication(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new LoanNotFound("No loan issued to this id.");
		}
	}
	
	

}
