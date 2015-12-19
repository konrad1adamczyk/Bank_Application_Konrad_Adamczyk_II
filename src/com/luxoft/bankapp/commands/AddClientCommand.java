package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.ecxeptions.ClientNotExistsException;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.model.Gender;
import com.luxoft.bankapp.service.BankCommander;

import java.io.IOException;

/**
 * Created by KAdamczyk on 2015-12-18.
 */
public class AddClientCommand implements Command {

//    Register the new client by entering data about him, including the next: (AddClientCommand)
//    ·      Full client name*
//    ·      Electronic address of the client*
//    ·      Phone number of the client*
//    ·      Overdraft of the client*

    @Override
    public void execute() {

        try {
            String name = UserInterface.getFullName();
            String email = UserInterface.getEmail();
            String phone = UserInterface.getPhone();
            Gender gender = UserInterface.getGender();
            float initialOverdraft = Float.parseFloat(UserInterface.getOverdraft());

            Client client = new Client(name,gender,initialOverdraft,email,phone);
            BankCommander.currentBank.addClient(client);
            BankCommander.currentClient = client;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClientExistsException cee) {
            System.out.println(cee.printMessage());
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.print("Add new client.");
    }
}
