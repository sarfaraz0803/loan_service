package com.nlb.loanservice.service;

import com.nlb.loanservice.entity.LoanApplication;

public interface ILoanApplicationService {
	
	LoanApplication saveLoanApplication(LoanApplication loanapp);
	LoanApplication approveLoanApplication(int loanId);
	LoanApplication rejectLoanApplication(int loanId);
}
