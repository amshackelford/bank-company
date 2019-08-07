package com.shackman;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("PNC");

    public static void main(String[] args) {
        boolean quit = false;
        printOptions();

        while (!quit) {
            System.out.print ("\nEnter your selection (Press 0 to see options): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {

                case 0:
                    printOptions();
                    break;
                case 1:
                    bank.printBranches();
                    break;
                case 2:
                    bank.addBranch();
                    break;
                case 3:
                    printCustomers();
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    addTransaction();
                    break;
                case 6:
                    printTransactions();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Shutting down...");
                    break;
            }
        }
    }

    public static void printOptions() {
        System.out.println("Available Options: \nPress ");
        System.out.println("\t 0 - to View Options");
        System.out.println("\t 1 - to View Branches");
        System.out.println("\t 2 - to Add a new branch");
        System.out.println("\t 3 - to View customers at branch");
        System.out.println("\t 4 - to Add a new customer");
        System.out.println("\t 5 - to Add a transaction for a customer");
        System.out.println("\t 6 - to View customer transaction");
        System.out.println("\t 7 - to quit");
    }

    public static void printCustomers() {
        bank.printBranchCustomers(promptForBranch());
    }

    public static void addCustomer() {
        bank.addCustomerToBranch(promptForBranch());
    }

    public static void addTransaction() {
        bank.addCustomerTransaction(promptForBranch());
    }

    public static void printTransactions() {
        bank.printMemberTransaction(promptForBranch());
    }

    public static Branch promptForBranch() {
        System.out.print("Please enter branch name: ");
        String tempName = scanner.nextLine();
        Branch tempBranch = new Branch(tempName);
        return tempBranch;
    }
}