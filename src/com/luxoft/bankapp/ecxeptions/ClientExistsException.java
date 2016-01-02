package com.luxoft.bankapp.ecxeptions;


public class ClientExistsException extends Exception {

	private String name;

	public ClientExistsException(String name) {
		super(name);
	}


	public String printMessage() {
		return "Client with that name already exist: " + name;
	}

}
