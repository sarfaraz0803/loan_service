package com.nlb.loanservice.exception;

public class LoanGrantLimit extends RuntimeException{
	
	String msg;

	public LoanGrantLimit(String msg) {
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
