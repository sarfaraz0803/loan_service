package com.nlb.loanservice.exception;

public class LoanAlreadyExists extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public LoanAlreadyExists(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
