package com.luxoft.bankapp.requests;

/**
 * Created by Konrad on 2016-01-04.
 */
public class GetAccountsRequest implements Request {
    @Override
    public void printRequestInfo() {
        System.out.println("Get accounts");
    }
}
