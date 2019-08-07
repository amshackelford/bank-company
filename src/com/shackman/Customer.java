package com.shackman;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initTrans) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(initTrans);
    }

    public String getName() {
        return this.name;
    }

    public void printTransactions() {
        int tranNum = 1;
        for(Double transaction : transactions) {
            System.out.println("\t " + tranNum + ". " + transaction);
            tranNum++;
        }
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }
}
