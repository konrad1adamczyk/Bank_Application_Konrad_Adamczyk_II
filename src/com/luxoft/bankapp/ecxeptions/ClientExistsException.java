package com.luxoft.bankapp.ecxeptions;


public class ClientExistsException extends Exception {
	private static final long serialVersionUID = 8407159239142297435L;

	public ClientExistsException(String msg) {
		super(msg);
	}
}
