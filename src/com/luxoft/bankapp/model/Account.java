package com.luxoft.bankapp.model;

import com.luxoft.bankapp.ecxeptions.BankException;

public interface Account extends Report{
	
	public float getBalance();
	public void deposit(float x);
	public void withdraw(float x) throws BankException;


}
