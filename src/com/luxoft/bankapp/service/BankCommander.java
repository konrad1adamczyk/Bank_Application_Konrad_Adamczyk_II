package com.luxoft.bankapp.service;

import com.luxoft.bankapp.commands.*;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by KAdamczyk on 2015-12-18.
 */
public class BankCommander {

    public static Bank currentBank = new Bank("MyBank");
    public static Client currentClient;

    static Command[] commands = {
            new AddClientCommand(), // 1
            new FindClientCommand(), // 2
            new OpenAccountCommand(), // 3
            new CloseAccountCommand(), // 4
            new GetAccountsCommand(), // 5
            new SetActiveAccountCommand(), // 6

            new DepositCommand(), // 7
            new WithdrawCommand(), // 8
            new TransferCommand(), // 9

            new Command() { // 10 - Exit Command
                public void execute() {
                    System.out.println("Closing the program!");
                    System.exit(0);
                }
                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            }
    };

    private static void showMenu() {
        System.out.print("\n BANK MENU: Active client: ");
        if (currentClient != null) {
            System.out.print(currentClient.getFirstname());
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
