package com.luxoft.bankapp.model;

import java.util.*;

public class Client implements Report
{
	private Gender gender;
	private float balance;
	private String firstname;
	private String surname;
	private List<Account> listOfAccounts = new ArrayList<Account>();
	private Account activeAccont;
	private float initialOverdraft;

	// Add the possibility to keep a gender of the bank customer. Define the
	// relevant fields and Client class constructor.

	public Client(String surname, String firstname)
	{
		this.surname = surname;
		this.firstname = firstname;
		this.listOfAccounts = new ArrayList<Account>(2);
	}

	public Client(String surname, String firstname, float initialOverdraft)
	{
		this.surname = surname;
		this.firstname = firstname;
		this.initialOverdraft = initialOverdraft;
		this.listOfAccounts = new ArrayList<Account>(2);
	}

	public Client(Gender gender, String surname, String firstname, float initialOverdraft)
	{
		this.gender = gender;
		this.surname = surname;
		this.firstname = firstname;
		this.initialOverdraft = initialOverdraft;
		this.listOfAccounts = new ArrayList<Account>(2);
	}

	public String getFirstname()
	{
		return firstname;
	}

	public String getSurname()
	{
		return surname;
	}

	public float getInitialOverdraft()
	{
		return initialOverdraft;
	}

	public void setInitialOverdraft(float initialOverdraft)
	{
		this.initialOverdraft = initialOverdraft;
	}

	public void setActiveAccont(Account activeAccont)
	{
		this.activeAccont = activeAccont;
	}

	public List<Account> getListOfAccounts()
	{
		return Collections.unmodifiableList(listOfAccounts);
	}

	public void addAccount(Account account1)
	{
		listOfAccounts.add(account1);
	}

	public String getClientSalutation()
	{
		return gender.getClientSalutation();
	}

	@Override
	public void printReport()
	{
		// the customer should override method printReport (), which has to
		// display information about the customer and all of its accounts
		 System.out.print("\n" + getClientSalutation() + " " + firstname + " " + surname + "\n" );
		 listOfAccounts.forEach(account -> account.printReport());

		 
//		 po co %20s%6.2f\n   i %s%s\n????????????????
		 
	}


}
