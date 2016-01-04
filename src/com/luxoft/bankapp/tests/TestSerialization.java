package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.model.Gender;
import com.luxoft.bankapp.service.BankService;
import com.luxoft.bankapp.service.BankServiceImpl;


/**
 * Created by Konrad on 2016-01-03.
 */
public class TestSerialization {
    public static Bank currentBank;

    public static Client currentClient;

    public static void main(String[] args) throws ClientExistsException {

//        BankApplication bankApp = new BankApplication();
//        currentBank = new Bank("bankTest");
//        bankApp.initialize(currentBank);
//        currentBank.printReport();

        BankService bankService = new BankServiceImpl();

        Client client = new Client("Konradek Ad", Gender.MALE, 5432f, "konradek@gmail.com", "294-543-234", "Krakow");

        Client client2 = new Client("Ania Ka", Gender.FEMALE, 1234f, "ania@gmail.com", "291-569-567", "Krynica");

        bankService.saveClient(client);
        bankService.saveClient(client2);

        Client recoverClient1 = bankService.loadClient();
        Client recoverClient2 = bankService.loadClient();

        client2.printReport();
        recoverClient1.printReport();
        System.out.println("------------------------");
        recoverClient2.printReport();
//        currentBank.printReport();


    }
}



