package com.luxoft.bankapp.model;

import com.luxoft.bankapp.ecxeptions.BankException;

public interface Account extends Report{
	
	public float getBalance();
	public void setBalance(float balance);
	public void deposit(float ammount);
	public void withdraw(float ammount) throws BankException;
	public float decimalValue();

	public String getAccountNumber();
}
