package com.luxoft.bankapp.service;

import com.luxoft.bankapp.ecxeptions.ClientExistsException;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Konrad on 2016-01-01.
 */
public class BankFeedService {

    public static final String FILE_PATH = "test.txt";

    public void loadFeed() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader =  new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            Map<String, String> feedMap = new HashMap<String, String>();
            String []splitLine;
            String line = bufferedReader.readLine();
            String []splitValues;
            while(line != null){

                splitLine = line.split(";");
                for(String nodes: splitLine){
                    splitValues = nodes.split("=");
                    feedMap.put( splitValues[0], splitValues[1]);
                }
                BankCommander.currentBank.parseFeed(feedMap);

                feedMap.clear();
                splitLine = null;
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
