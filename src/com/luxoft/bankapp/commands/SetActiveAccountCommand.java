package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.service.BankCommander;

import java.io.IOException;
import java.util.List;

/**
 * Created by Konrad on 2015-12-19.
 */
public class SetActiveAccountCommand implements Command {
    @Override
    public void execute() {
        if (BankCommander.currentClient != null &&
                BankCommander.currentClient.getActiveAccount() != null) {
            try {
                List<Account> accounts = BankCommander.currentClient.getListOfAccounts();
                int index = Integer.parseInt(UserInterface.getActiveAccountIndex(accounts));

                BankCommander.currentClient.setActiveAccount(accounts.get(index));
                System.out.println("Choosen account: ");
                accounts.get(index).printReport();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No active client or no accounts.");
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.print("Set active account.");
    }
}
