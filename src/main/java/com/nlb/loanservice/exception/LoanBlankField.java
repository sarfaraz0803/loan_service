package com.nlb.loanservice.exception;

public class LoanBlankField extends RuntimeException {

	
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LoanBlankField(String msg) {
		super();
		this.msg = msg;
	}
	
}
	
