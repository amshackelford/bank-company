package com.shackman;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch {
    private static Scanner scanner = new Scanner(System.in);

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return this.branchName;
    }

    public void printCustomer() {
        int counter = 1;
        System.out.println("There are " + customers.size() + " customers at this bank.");
        for (Customer customer : customers) {
            System.out.println("\t" + counter + ". " + customer.getName());
        }
    }

    public void addCustomer(){
        System.out.print("Please enter customer name: ");
        String newCustName = scanner.nextLine();
        System.out.print("Please enter the inital transaction: ");
        double initTrans = scanner.nextDouble();
        scanner.nextLine();
        Customer newCustomer = new Customer(newCustName, initTrans);
        if (customerExists(newCustomer)) {
            System.out.println("This customer already has an account");
        } else {
            customers.add(newCustomer);
            System.out.println("New customer added, Name: " + newCustName + ", Initial Transaction Added -> " + initTrans);
        }
    }

    public void addTransaction() {
        System.out.print("Enter the name of customer: ");
        String tempName = scanner.nextLine();
        System.out.print("Please enter the transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Customer tempCust = new Customer(tempName, amount);
        if (customerExists(tempCust)) {
            getCustomer(tempCust).getTransactions().add(amount);
            System.out.println(amount + " was added");
            System.out.println("Transaction successful");
        } else {
            System.out.println("Customer not found");
        }
    }

    public void printCustTransactions() {
        System.out.print("Enter the name of customer: ");
        String tempName = scanner.nextLine();
        Customer customer = new Customer(tempName, 0);
        if (customerExists(customer)) {
            getCustomer(customer).printTransactions();
        } else {
            System.out.println("Customer not found.");
        }
    }

    private boolean customerExists(Customer newCust) {
        Customer tempCust = getCustomer(newCust);
        if (tempCust != null) {
            return true;
        } else {
            return false;
        }
    }

    private Customer getCustomer(Customer newCust) {
        String name = newCust.getName();
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}