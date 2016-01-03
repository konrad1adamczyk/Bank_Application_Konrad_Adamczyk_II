package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.model.*;
import com.luxoft.bankapp.service.BankApplication;
import com.luxoft.bankapp.service.BankService;
import com.luxoft.bankapp.service.BankServiceImpl;


/**
 * Created by Konrad on 2016-01-03.
 */
public class TestSerialization {
    public static void main(String[] args) throws ClientExistsException {

        Bank currentBank;
        BankApplication bankApp = new BankApplication();

        currentBank = new Bank("bankTest");
//        bankApp.initialize(currentBank);

        currentBank.printReport();

        BankService bankService;

        bankService = new BankServiceImpl();

        Client client = new Client("Konradek", Gender.MALE, 5432f, "konradek@gmail.com",
                "294-543-234", "Krakow");

        bankService.saveClient(client);
        Client recoverClient = bankService.loadClient();

//        assertTrue(client.equals(recoverClient));
        recoverClient.printReport();


    }
}



