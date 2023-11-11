package com.nlb.loanservice.exception;

public class LoanNotFound extends RuntimeException{
<<<<<<< HEAD

	private static final long serialVersionUID = 1L;
=======
	
>>>>>>> refs/heads/develop
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
