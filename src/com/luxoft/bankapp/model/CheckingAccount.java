package com.luxoft.bankapp.model;

public class CheckingAccount extends AbstractAccount
{
	private float balance;
	private float overdraft;

	public CheckingAccount(float balance)
	{
		super(balance);
	}
	public CheckingAccount(String accountNumber, float balance)
	{
		super(accountNumber, balance);
	}

	@Override
    public String toString() {
        return "Checking Account have balance: " + getBalance() + " and overdraft: " + getOverdraft();
    }

	public float getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(float overdraft)
	{
		this.overdraft = overdraft;
	}

	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance)
	{
		this.balance = balance;
	}

}
