package com.shackman;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private static Scanner scanner = new Scanner(System.in);

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>() {};
    }

    public String getName() {
        return this.name;
    }

    public void printBranches() {
        System.out.println("There are " + branches.size() + " branches.");
        int counter = 1;
        for (Branch branch : branches) {
            System.out.println(counter + ". " + branch.getName());
            counter++;
        }
    }

    public void addBranch() {
        System.out.print("Enter new branch name: ");
        String branchName = scanner.nextLine();
        Branch newBranch = new Branch(branchName);
        if (branchExists(newBranch)) {
            System.out.println("This branch already exists.");
        } else {
            branches.add(newBranch);
            System.out.println("Branch added successfully.");
        }
    }

    public void printBranchCustomers(Branch branchName) {
        if (branchExists(branchName)) {
            getBranch(branchName).printCustomer();
        } else {
            System.out.println("Unable to locate branch.");
        }
    }


    public void addCustomerToBranch(Branch branchName) {
        if (branchExists(branchName)) {
            getBranch(branchName).addCustomer();
        } else {
            System.out.println("Unable to locate branch.");
        }
    }

    public void addCustomerTransaction(Branch branchName) {
        if (branchExists(branchName)) {
            getBranch(branchName).addTransaction();
        } else {
            System.out.println("Unable to locate branch.");
        }
    }

    public void printMemberTransaction(Branch branchName) {
        if (branchExists(branchName)) {
            getBranch(branchName).printCustTransactions();
        } else {
            System.out.println("Unable to locate branch.");
        }
    }

    private boolean branchExists(Branch newBranch) {
        Branch tempBranch = getBranch(newBranch);
        if (tempBranch != null) {
            return true;
        } else {
            return false;
        }
    }

    private Branch getBranch(Branch newBranch) {
        String name = newBranch.getName();
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(name)) {
                return branch;
            }
        }
        return null;
    }
}