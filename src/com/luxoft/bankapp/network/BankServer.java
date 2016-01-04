package com.luxoft.bankapp.network;

import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by KAdamczyk on 2016-01-04.
 */
public class BankServer {
//    protected int serverPort;

    protected ServerSocket providerSocket;
    protected Socket connection = null;
    protected ObjectOutputStream out;
    protected ObjectInputStream in;
    String message;

    protected Bank activeBank;
    protected Client loggedClient;
   private int serverPort = 2004 ;
    public BankServer() {

    }
    public BankServer(Bank bank) {
        activeBank = bank;
    }
    public BankServer(Bank bank, int port) {
//        serverPort = port ;
        serverPort = 2004 ;
        activeBank = bank;
    }

    void run() {
//        activeBank.printReport();

        System.out.println("==============");
        System.out.println("localhost:" + serverPort);
        System.out.println("==============");

        try {
            // 1. creating a server socket
            providerSocket = new ServerSocket(serverPort, 10);
            // 2. Wait for connection
            System.out.println("Waiting for connection");
            connection = providerSocket.accept();
            System.out.println("Connection received from " + connection.getInetAddress().getHostName());
            // 3. get Input and Output streams
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection successful");
            // 4. The two parts communicate via the input and output streams
            do {
                try {
                    message = (String) in.readObject();
                    System.out.println("client> " + message);
                    if (message.equals("bye"))
                        sendMessage("bye");
                } catch (ClassNotFoundException classnot) {
                    System.err.println("Data received in unknown format");
                }
            } while (!message.equals("bye"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            // 4: Closing connection
            try {
                in.close();
                out.close();
                providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    void sendMessage(final String msg) {
        try {
            out.writeObject(msg);
            out.flush();
            System.out.println("server>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(final String args[]) {
        BankServer server = new BankServer( );
        while (true) {
            server.run();
        }
    }
}