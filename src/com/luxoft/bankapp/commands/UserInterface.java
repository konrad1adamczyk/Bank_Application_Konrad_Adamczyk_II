package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Gender;
import com.luxoft.bankapp.util.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Konrad on 2015-12-19.
 */
public class UserInterface {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static String getFullName() throws IOException {
        System.out.println("Enter full name: ");
        String name = reader.readLine();
        if (!Validation.checkIsFullName(name)) {
            System.out.println("Please provide firstname and surname with first capital letter!");
            name = getFullName();
        }
        return name;
    }

    static String getEmail() throws IOException {
        System.out.println("Enter email address: ");
        String email = reader.readLine();
        if (!Validation.checkIsEmail(email)) {
            System.out.println("Invalid format of email!");
            email = getEmail();
        }
        return email;
    }

    static Gender getGender() throws IOException {
        System.out.println("Choose gender: ");
        System.out.println("0) Male ");
        System.out.println("1) Female");
        String genderStr = reader.readLine();
        if (!Validation.checkIsExpectedNumber(genderStr, 1)) {
            System.out.println("Invalid number selected!");
            getGender();
        }
        Gender gender = null;
        switch (genderStr) {
            case "0": gender = Gender.MALE; break;
            case "1": gender = Gender.FEMALE; break;
        }
        return gender;
    }

    static String getPhone() throws IOException {
        System.out.println("Enter phone number: ");
        String phone = reader.readLine();
        if (!Validation.checkIsPhone(phone)) {
            System.out.println("Invalid phone number!");
            phone = getPhone();
        }
        return phone;
    }

    static String getOverdraft() throws IOException {
        System.out.println("Enter initial overdraft: ");
        String overdraftStr = reader.readLine();
        if (!Validation.checkIsNumeric(overdraftStr)) {
            System.out.println("Invalid format of overdraft!");
            overdraftStr = getOverdraft();
        }
        return overdraftStr;
    }

    static String getAccountType() throws IOException {
        System.out.println("Choose account type: ");
        System.out.println("0) Saving account ");
        System.out.println("1) Checking account");
        String accountStr = reader.readLine();
        if (!Validation.checkIsExpectedNumber(accountStr, 1)) {
            System.out.println("Invalid number selected!");
            accountStr = getAccountType();
        }
        return accountStr;
    }

    static String getAmount(String actionName) throws IOException {
        System.out.println("Operation: " + actionName + ", enter amount: ");
        String amountStr = reader.readLine();
        if (!Validation.checkIsNumeric(amountStr)) {
            System.out.println("Invalid number format!");
            amountStr = getAmount(actionName);
        }
        return amountStr;
    }

    static String getActiveAccountIndex(Set<Account> accounts) throws IOException {
        System.out.println("Choose account: ");

        for (Iterator<Account> it = accounts.iterator(); it.hasNext(); ) {
           Account ac = it.next();
            System.out.print(it + ") ");
            ac.printReport();
        }




//        Set<Foo> set = new HashSet<Foo>();
//        set.add(new Foo("Hello"));
//
//        for (Iterator<Foo> it = set.iterator(); it.hasNext(); ) {
//            Foo f = it.next();
//            if (f.equals(new Foo("Hello")))
//                System.out.println("foo found");}


        String indexStr = reader.readLine();
        if (!Validation.checkIsExpectedNumber(indexStr, accounts.size()-1)) {
            System.out.println("Invalid number selected!");
            indexStr = getActiveAccountIndex(accounts);
        }
        return indexStr;
    }


}
