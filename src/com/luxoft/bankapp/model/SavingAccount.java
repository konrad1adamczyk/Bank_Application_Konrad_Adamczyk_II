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
	public float getBalance() {
		return balance;
	}

	@Override
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(float overdraft) {
		this.overdraft = overdraft;
	}
	
	
	 @Override
	    public String toString() {
	        return "Saving Account have balance: " + getBalance() + " and overdraft: " + getOverdraft();
	    }


}