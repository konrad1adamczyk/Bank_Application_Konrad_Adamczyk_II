package com.luxoft.bankapp.service;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

public class BankServiceImpl implements BankService
{

	@Override
	public void addClient2(Bank bank, Client client) throws ClientExistsException {
		bank.addClient(client);

	}

	@Override
	public void removeClient(Bank bank, Client client)
	{
		bank.removeClient(client);

	}

	@Override
	public void addAccount(Client client, Account account)
	{
		client.addAccountToClient(account);

	}

	@Override
	public void setActiveAccount(Client client, Account account)
	{
		client.setActiveAccount(account);

	}

//	@Override
//	public void removeClientByIndex(Bank bank, int index)
//	{
//		bank.removeClientByIndex(index);
//	}

}
