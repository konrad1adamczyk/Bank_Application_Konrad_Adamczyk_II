package com.luxoft.bankapp.ecxeptions;

/**
 * Created by Konrad on 2015-12-19.
 */
public class ClientNotExistsException extends Throwable {
    private String name;

    public ClientNotExistsException(){
    }

    public ClientNotExistsException(String name) {
        this.name = name;
    }

    public String printMessage() {
        if (name != null)
            return "Client with that name not exist: " + name;
        else
            return "No client";
    }
}
