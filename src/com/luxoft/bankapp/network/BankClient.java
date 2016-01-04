package com.luxoft.bankapp.network;

import com.luxoft.bankapp.requests.*;
import com.luxoft.bankapp.service.BankServiceImpl;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by KAdamczyk on 2016-01-04.
 */
public class BankClient {

    protected Socket requestSocket;
    protected ObjectOutputStream out;
    protected ObjectInputStream in;
    protected String message;
    protected static final String SERVER = "localhost";
    protected final int port;
    protected Request[] requestArray = {
            new LogInRequest(),
            new GetAccountsRequest(),
            new ChangeActiveAccountRequest(),
            new DepositRequest(),
            new WithdrawRequest(),
            new LogOutRequest()};
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public BankClient(int port) {
        this.port = port;
    }

    public void printRequests() {
        int i = 1;
        for (Request request : requestArray) {
            System.out.print(i + ") ");
            request.printRequestInfo();
            i++;
        }
    }

    public void sendRequest(Request request) {
        try {
            out.writeObject(request);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeActiveAccount() {
        System.out.println("Write account id number: ");
        String id = null;
        try {
            id = reader.readLine();
            ChangeActiveAccountRequest changeActiveAccountRequest =
                    new ChangeActiveAccountRequest();
            changeActiveAccountRequest.setAccountId(Integer.valueOf(id));
            sendRequest(changeActiveAccountRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deposit() {
        System.out.println("Write amount of money to deposit: ");
        String amount = null;
        try {
            amount = reader.readLine();
            DepositRequest depositRequest = new DepositRequest();
            depositRequest.setDepositAmount(Float.valueOf(amount));
            sendRequest(depositRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void withdraw() {
        System.out.println("Write amount of money to withdraw: ");
        String amount = null;
        try {
            amount = reader.readLine();
            WithdrawRequest withdrawRequest = new WithdrawRequest();
            withdrawRequest.setWithdrawAmount(Float.valueOf(amount));
            sendRequest(withdrawRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serviceRequest() throws IOException {
        printRequests();
        reader = new BufferedReader(new InputStreamReader(System.in));

        String answer = reader.readLine();

        if (answer.equals("1")) {
            System.out.println("Write your name to log in: ");
            String name = reader.readLine();
            LogInRequest logInRequest = new LogInRequest(name);
            sendRequest(logInRequest);
        } else if (answer.equals("2")) {
            sendRequest(new GetAccountsRequest());
        } else if (answer.equals("3")) {
            changeActiveAccount();
        } else if (answer.equals("4")) {
            deposit();
        } else if (answer.equals("5")) {
            withdraw();
        } else if (answer.equals("6")) {
            message = "bye";
            sendRequest(new LogOutRequest());
        }
    }



    void run() {
        try {

            requestSocket = new Socket(SERVER, port);
            System.out.println("Connected to localhost in port " + port);
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            do {
                try {
                    message = (String) in.readObject();
                    System.out.println("server> " + message);
                    serviceRequest();

                } catch (ClassNotFoundException classNot) {
                    System.err.println("Data received in unknown format");
                }
            } while (!message.equals("bye"));
        } catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

//    void sendMessage(final String msg) {
//        try {
//            out.writeObject(msg);
//            out.flush();
//            System.out.println("client>" + msg);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }

    public static void main(final String args[]) {
        int port = 2004;
        BankClient client = new BankClient(port);
        client.run();
    }

}