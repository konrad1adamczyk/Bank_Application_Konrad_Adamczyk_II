package com.luxoft.bankapp.model;

public class SavingAccount extends AbstractAccount
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


}