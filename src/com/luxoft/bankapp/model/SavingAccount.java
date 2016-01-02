package com.luxoft.bankapp.model;

import java.io.Serializable;
import java.util.Map;

public class SavingAccount extends AbstractAccount implements Serializable
{
	private float balance;
	private float overdraft;

	public SavingAccount(String accountNumber, float balance)
	{
		super(accountNumber, balance);
	}


	public SavingAccount(float balance)
	{
		super(balance);
	}
	// printReport(), displaying information about this account: the type of
	// account and the balance.

	
	 @Override
	    public String toString() {
	        return "Saving Account have balance: " + getBalance() + " and overdraft: " + getOverdraft();
	    }




	@Override
	public String getAccountType() {
		return "s";
	}
}