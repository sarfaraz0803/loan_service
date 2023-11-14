package com.nlb.loanservice.service;

import java.util.NoSuchElementException;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlb.loanservice.entity.LoanApplication;
import com.nlb.loanservice.entity.Rating;
import com.nlb.loanservice.entity.Status;
import com.nlb.loanservice.exception.LoanAlreadyExists;
import com.nlb.loanservice.exception.LoanBlankField;
import com.nlb.loanservice.exception.LoanGrantLimit;
import com.nlb.loanservice.repository.LoanApplicationRepository;

@Service
public class LoanApplicationServiceImpl implements ILoanApplicationService {

	@Autowired
	LoanApplicationRepository loanAppRepo;

	@Override
	public LoanApplication saveLoanApplication(LoanApplication loanApp) {
		if (loanAppRepo.existsById(loanApp.getId())) {
			throw new LoanAlreadyExists("Already Exists");
		} else if (loanApp.getRequestedAmount() < 10000.0 || loanApp.getRequestedAmount() > 2000000.0) {
			throw new LoanGrantLimit("LoanAmount must between 1000 to 2000000.");
		} else if (loanApp.getBankName() == "") {
			throw new LoanBlankField("Bank Name should not be empty");
		} else {

			LoanApplication loanApp1 = new LoanApplication();
			loanApp1.setId(loanApp.getId());
			loanApp1.setBankName(loanApp.getBankName());
			loanApp1.setRequestedAmount(loanApp.getRequestedAmount());
			loanApp1.setTermLength(loanApp.getTermLength());
			loanApp1.setMinInterestRate(10000.0);
			loanApp1.setMaxLoanAmount(2000000);
			loanApp1.setMinCreditScore(10.0);
			loanApp1.setMinInterestRate(0.07);
			loanApp1.setProcessingFee(loanApp.getRequestedAmount() * 0.005);
			loanApp1.setStatus(Status.PENDING);
			loanApp1.setRating(Rating.SATISFIED);
			return loanAppRepo.save(loanApp1);
		}
	}

	@Override
	public LoanApplication approveLoanApplication(int loanId) throws NoSuchElementException {
		LoanApplication loanApp = loanAppRepo.findById(loanId).get();
		loanApp.setStatus(Status.APPROVED);
		loanAppRepo.save(loanApp);
		return loanApp;
	}

	@Override
	public LoanApplication rejectLoanApplication(int loanId) throws NoSuchElementException {
		LoanApplication loanApp = loanAppRepo.findById(loanId).get();
		loanApp.setStatus(Status.REJECTED);
		loanAppRepo.save(loanApp);
		return loanApp;
	}

	@Override
	public LoanApplication displayLoanById(int loanId) {
		LoanApplication loanApp = loanAppRepo.findById(loanId).get();
		return loanApp;
	}

}
