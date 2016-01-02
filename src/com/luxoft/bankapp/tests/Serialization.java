package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.model.*;
import com.luxoft.bankapp.service.BankFeedService;
import com.luxoft.bankapp.service.BankServiceImpl;

/**
 * Created by Konrad on 2016-01-02.
 */
public class Serialization {
    public static void main(String[] args) {

        BankFeedService bankFeedService = new BankFeedService();
        bankFeedService.loadFeed();
        BankServiceImpl bankService = new BankServiceImpl();

        Client client1 = new Client("Konradek","Krakow","Konradek@gmail.com","123456854", Gender.MALE, 1000);

        Account savingAccount = new SavingAccount(300);
        Account checkingAccount = new CheckingAccount(300);
        bankService.addAccount(client1,savingAccount);
        bankService.addAccount(client1,checkingAccount);
        bankService.setActiveAccount(client1,checkingAccount);

        bankService.saveClient(client1);
        System.out.println(bankService.loadClient());
    }
}
