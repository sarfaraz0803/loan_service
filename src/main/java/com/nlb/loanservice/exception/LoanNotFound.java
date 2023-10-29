package com.nlb.loanservice.exception;

public class LoanNotFound extends RuntimeException{
	
	private String msg;

	public LoanNotFound(String msg) {
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
