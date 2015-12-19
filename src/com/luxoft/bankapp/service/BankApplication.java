package com.luxoft.bankapp.service;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.model.*;

import com.luxoft.bankapp.ecxeptions.BankException;

public class BankApplication
{

	public static void main(String[] args) throws BankException, ClientExistsException {
		System.out.println("hello from bank app \n");

		BankApplication bankApp = new BankApplication();
		Bank pekao = new Bank("PeKaO");

		bankApp.initialize(pekao);

		printBankReport(pekao);
		

		 modifyBank(pekao);
		 pekao.printReport();

	}

	public static void initialize(Bank bank) throws ClientExistsException {
		BankServiceImpl bankService = new BankServiceImpl();

		Client[] clients = new Client[]
		{ new Client(Gender.MALE, "Saladra Dawid", 7000), new Client(Gender.FEMALE, "Chrobak Monika", 4500), new Client(Gender.MALE, "Skurski Piotr", 2600),
				new Client(Gender.MALE, "Tympalski Pawel", 5500), new Client(Gender.FEMALE, "Szpak Aleksandra", 1400), new Client(Gender.MALE, "Raczkowski Przemyslaw", 4000),
				new Client(Gender.MALE, "Rosner Pawel", 800), new Client(Gender.FEMALE, "Banasik Patrycja", 900), new Client(Gender.FEMALE, "Shaleiko Oksana", 1000),
				new Client(Gender.MALE, "Adamczyk Konrad", 5000), new Client(Gender.MALE, "Krzeminski Jaroslaw", 700), new Client(Gender.MALE, "Chlebda Lukasz", 200) };

		for (int i = 0; i < clients.length; i++)
		{
			bankService.addClient2(bank, clients[i]);

			AbstractAccount accountChecking = new CheckingAccount(100);
			accountChecking.setAccountNumber();
			bankService.addAccount(clients[i], accountChecking);

			AbstractAccount accountSaving = new SavingAccount(100);
			accountSaving.setAccountNumber();
			bankService.addAccount(clients[i], accountSaving);

		}

	}

	public static void modifyBank(Bank bank) throws BankException, ClientExistsException {
		BankServiceImpl bankService = new BankServiceImpl();
		Client client = new Client(Gender.FEMALE, "Anna Pierzga", 1200);
		
		bankService.addClient2(bank, client);

		AbstractAccount accountChecking = new CheckingAccount(1200);
		accountChecking.setAccountNumber();
		bankService.addAccount(client, accountChecking);

		AbstractAccount accountSaving = new SavingAccount(1200);
		accountSaving.setAccountNumber();
		bankService.addAccount(client, accountSaving);

		for(Client client1: bank.getListOfClients())
			for (Account account : client1.getListOfAccounts()) {
				account.withdraw(50000);
				account.deposit(700);
			}
		
		bankService.removeClientByIndex(bank, 2);
		bankService.removeClientByIndex(bank, 1);
		bankService.removeClientByIndex(bank, 0);
		
	}


	private static void printBankReport(Bank bank)
	{ 
		bank.printReport();
		// Implement a method BankApplication.printBankReport (), displaying the
		// balance on every account of all bank customers. The method should
		// cause Bank.printReport ().
		// Bank.printReport();
	}

}
