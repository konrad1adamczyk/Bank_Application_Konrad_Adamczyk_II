package com.luxoft.bankapp.service;

import com.luxoft.bankapp.commands.*;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.luxoft.bankapp.service.BankApplication.*;

/**
 * Created by KAdamczyk on 2015-12-18.
 */
public class BankCommander {

    public static Bank currentBank = new Bank("MyBank");
    public static Client currentClient;

    static Command[] commands = {
            new AddClientCommand(), // 0    ***************
            new FindClientCommand(), // 1   ***************
            new OpenAccountCommand(), // 2  ***************
//            new CloseAccountCommand(), // 3
            new GetAccountsCommand(), // 4  ***************
            new SetActiveAccountCommand(), // 5 ***************

            new DepositCommand(), // 6 ***************
            new WithdrawCommand(), // 7 ***************
            new TransferCommand(), // 8

            new Command() { // 9 - Exit Command
                @Override
                public void execute() {
                    System.out.println("Closing the program!");
                    System.exit(0);
                }
                @Override
                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            }
    };

    private static void showMenu() {
        System.out.print("\n BANK MENU: Active client: ");
        if (currentClient != null) {
            System.out.print(currentClient.getName());
        } else {
            System.out.print("none");
        }
        System.out.println();

        for (int i = 0; i < commands.length; i++) {
            System.out.print(i + ") ");
            commands[i].printCommandInfo();
            System.out.println();
        }
        System.out.println("Choose a number: ");
    }

    public static void main(String args[]) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            showMenu();
            try {
                String commandString = reader.readLine();
                int command = Integer.valueOf(commandString.trim());
                commands[command].execute();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid number selected!");
            }
        }
    }
}
