package com.example.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String bankName;
    private final List<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    // Add a new account
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created for: " + account.getAccountHolder());
    }

    // Find account by account number
    public Account getAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found with number: " + accountNumber);
        return null;
    }

    // Display all accounts
    public void displayAllAccounts() {
        System.out.println("\n=== All Accounts in " + bankName + " ===");
        for (Account account : accounts) {
            account.displayAccountDetails();
        }
    }
}
