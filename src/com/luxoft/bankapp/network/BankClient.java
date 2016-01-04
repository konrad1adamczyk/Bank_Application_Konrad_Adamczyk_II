package com.luxoft.bankapp.network;

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
    protected String user = null;

    protected BankServiceImpl bankService = new BankServiceImpl();

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public BankClient(int port) {
        this.port = port;
    }

    void run() {
        try {
            // 1. creating a socket to connect to the server
            requestSocket = new Socket(SERVER, port);
            System.out.println("Connected to localhost in port " + port);
            // 2. get Input and Output streams
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            // 3: Communicating with the server
            do {
                try {
                    message = (String) in.readObject();
                    System.out.println("server> " + message);
                    sendMessage("Hi my server");
                    message = "bye";
                    sendMessage(message);
                } catch (ClassNotFoundException classNot) {
                    System.err.println("data received in unknown format");
                }
            } while (!message.equals("bye"));
        } catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            // 4: Closing connection
            try {
                in.close();
                out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    void sendMessage(final String msg) {
        try {
            out.writeObject(msg);
            out.flush();
            System.out.println("client>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(final String args[]) {
        int port = 2004;
        BankClient client = new BankClient(port);
        client.run();
    }

}