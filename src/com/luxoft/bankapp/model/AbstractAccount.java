package com.luxoft.bankapp.model;

import com.luxoft.bankapp.ecxeptions.BankException;

public abstract class AbstractAccount implements Account
{

	private float balance;
	protected String accountNumber;


	public AbstractAccount(float balance)
	{
		this.balance = balance;
	}

	public AbstractAccount(String accountNumber, float balance)
	{
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public float getBalance()
	{
		return balance;
	}

	public void setBalance(float balance)
	{
		this.balance = balance;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public String getTwoDigits()
	{
		String twoDigits = String.valueOf((int) (Math.random() * 100));
		return twoDigits;
	}

	public String getFourDigits()
	{
		String fourDigits = String.valueOf((int) (Math.random() * 10000));
		return fourDigits;
	}

	public void setAccountNumber()
	{
		StringBuilder newAccountNumber = new StringBuilder();
		newAccountNumber.append(getTwoDigits()).append(" ").append(getFourDigits()).append(" ").append(getFourDigits()).append(" ").append("0000 0000").append(" ").append(getFourDigits()).append(" ").append(getFourDigits())
				.append(" ");

		String newAccountNumberString = newAccountNumber.toString();
		this.accountNumber = newAccountNumberString;

	}

	public void withdraw(float amount) throws BankException
	{
		if (getBalance() >= amount)
		{
			balance = balance - amount;
		} else
		{
			StringBuilder sb = new StringBuilder();
			sb.append("The balance is ").append(getBalance()).append(" so withdraw of ").append(amount).append(" is anavailable.");
			System.out.println(sb);
		}

	}

	public void deposit(float amount)
	{
		balance = balance + amount;

	}

	public void printReport()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("This ").append(this.toString()).append(" with account number: ").append(getAccountNumber()).append("Has balance of ").append(getBalance()).append(" USD");
		System.out.println(sb);

	}

}
