package com.luxoft.bankapp.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import com.luxoft.bankapp.model.*;
import com.luxoft.bankapp.service.BankApplication;
import com.luxoft.bankapp.service.BankService;
import com.luxoft.bankapp.service.BankServiceImpl;


/**
 * Created by Konrad on 2016-01-03.
 */
public class SerializationTest {

    private Bank bank;
    private BankService bankService;

    @Test
    public void saveAndLoadClientTest() {

        BankService bankService = new BankServiceImpl();
        Client client = new Client("Konradek Koba", Gender.MALE, 5432f, "konradek@gmail.com", "294-543-234", "Krakow");

        bankService.saveClient(client);
        Client recoverClient = bankService.loadClient();

        assertTrue(client.equals(recoverClient));
    }
}



