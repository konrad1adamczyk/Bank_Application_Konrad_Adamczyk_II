package com.luxoft.bankapp.service;

import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.commands.Command;
/**
 * Created by KAdamczyk on 2015-12-18.
 */
public class BankCommander {

    public static Bank currentBank = new Bank("MyBank");
    public static Client currentClient;

    static Command[] commands = {
//            new FindClientCommand(), // 1
//            new GetAccountCommand(), // 2
            // etc.
            new Command() { // 7 - Exit Command
                public void execute() {
                    System.exit(0);
                }
                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            }
    };

    public static void main(String args[]) {
        while (true) {
            for (int i=0;i<commands.length;i++) { // show menu
                System.out.print(i+") ");
                commands[i].printCommandInfo();
            }
            String commandString = System.console().readLine();
            int command=0; // initialize command with commandString
            commands[command].execute();
        }
    }
}
