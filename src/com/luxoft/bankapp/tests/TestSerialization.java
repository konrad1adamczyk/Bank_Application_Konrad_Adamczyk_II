package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.ecxeptions.ClientNotExistsException;
import com.luxoft.bankapp.model.*;
import com.luxoft.bankapp.service.BankApplication;
import com.luxoft.bankapp.service.BankFeedService;
import com.luxoft.bankapp.service.BankService;
import com.luxoft.bankapp.service.BankServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;


/**
 * Created by Konrad on 2016-01-01.
 */
public class TestSerialization {

    BankService bService;
    Bank bank;
    Client client;

//    @Before
//    public void peeperTest() throws ClientExistsException {
//
//        BankApplication bankApp = new BankApplication();
//        bank = new Bank("MyBank");
//        bankApp.initialize(bank);
//
//        bService = new BankServiceImpl();
//        client = null;
//    }
//
//    @Test
//    public void testAObjectSerialize() throws ClientNotExistsException {
//        bService.saveClient(bank.getClient(clientName));
//    }
//
//    @Test
//    public void testBObjectDeserialize() throws ClientNotExistsException, ClientExistsException {
//        bService.removeClient(bank, bank.getClient(clientName));
//        assertEquals(null, bank.getClient(clientName));
//        client = bService.loadClient(clientObject);
//        bService.addClient2(bank, client);
//        assertEquals(bank.getClient(clientName), client);
//        client.printReport();
//    }

    public static void main(String[] args) {

        BankFeedService bankFeedService = new BankFeedService();
        bankFeedService.loadFeed();
        BankServiceImpl bankService = new BankServiceImpl();

        Client client1 = new Client("Konradek","Krakow","franek@gmail.com","123456854", Gender.MALE,1000);

        Account savingAccount = new SavingAccount(300);
        Account checkingAccount = new CheckingAccount(300);
        bankService.addAccount(client1,savingAccount);
        bankService.addAccount(client1,checkingAccount);
        bankService.setActiveAccount(client1,checkingAccount);

        bankService.saveClient(client1);
        System.out.println(bankService.loadClient());
    }

}
