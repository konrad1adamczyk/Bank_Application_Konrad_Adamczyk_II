package com.luxoft.bankapp.service;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.ecxeptions.ClientNotExistsException;
import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.util.Validation;

import java.io.*;

public class BankServiceImpl implements BankService
{
	private static final String CLIENT_FILE = "resources/client.ser";

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

	@Override
	public Client getClient(Bank bank, String clientName) throws ClientNotExistsException {
		Validation.checkForNull(clientName);

		return bank.getClient(clientName);
	}

	@Override
	public void saveClient(Client client) {
		try (ObjectOutputStream ous = new ObjectOutputStream(
				new FileOutputStream(CLIENT_FILE))) {
			ous.writeObject(client);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client loadClient() {
		Client client = null;
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(CLIENT_FILE))) {
			client = (Client) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return client;
	}


}
