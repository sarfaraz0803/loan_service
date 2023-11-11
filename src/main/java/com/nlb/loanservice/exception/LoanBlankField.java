package com.nlb.loanservice.exception;

public class LoanBlankField extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msg;

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
	
