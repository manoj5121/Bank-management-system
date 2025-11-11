package com.example.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("Manoj Bank");

        // Create some accounts
        Account acc1 = new Account("A1001", "Manoj Kumar", 5000);
        Account acc2 = new Account("A1002", "Ravi Kumar", 3000);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        // Try-with-resources ensures Scanner is closed automatically
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- Bank Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Account Details");
                System.out.println("4. Display All Accounts");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter account number: ");
                        String accNum = sc.next();
                        Account account = bank.getAccountByNumber(accNum);
                        if (account != null) {
                            System.out.print("Enter deposit amount: ");
                            double amount = sc.nextDouble();
                            account.deposit(amount);
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter account number: ");
                        String accNum = sc.next();
                        Account account = bank.getAccountByNumber(accNum);
                        if (account != null) {
                            System.out.print("Enter withdrawal amount: ");
                            double amount = sc.nextDouble();
                            account.withdraw(amount);
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter account number: ");
                        String accNum = sc.next();
                        Account account = bank.getAccountByNumber(accNum);
                        if (account != null) {
                            account.displayAccountDetails();
                        }
                    }
                    case 4 -> bank.displayAllAccounts();
                    case 5 -> {
                        exit = true;
                        System.out.println("Exiting... Thank you!");
                    }
                    default -> System.out.println("Invalid option! Try again.");
                }
            }
        } // Scanner automatically closed here
    }
}
