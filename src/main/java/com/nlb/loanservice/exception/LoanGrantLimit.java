package com.nlb.loanservice.exception;

public class LoanGrantLimit extends RuntimeException{

	private static final long serialVersionUID = 1L;
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
