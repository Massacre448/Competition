package com.ING.transactions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EcoFriendlyApp {

    public static void main(String[] args) {
        String transactionsFilePath = "example_request.json";
        String outputFilePath = "output.txt";

        try {
            // Read transactions from the JSON file
            List<Transaction> transactions = TransactionUtils.readTransactionsFromFile(transactionsFilePath);

            // Process transactions and generate a map of accounts
            Map<String, Account> accountMap = TransactionProcessor.processTransactionsMap(transactions);

            // Create a sorted list of accounts
            List<Account> accounts = new ArrayList<>(accountMap.values());
            accounts.sort(Account::compareTo);

            // Print the sorted accounts with their debitCount, creditCount, and balance
            System.out.println("Account\t\t\tDebit Count\tCredit Count\tBalance");
            for (Account account : accounts) {
                System.out.printf("%s\t%d\t\t%d\t\t%.2f%n", account.getAccount(), account.getDebitCount(),
                        account.getCreditCount(), account.getBalance());
            }

            // Write the sorted accounts to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (Account account : accounts) {
                    writer.write(account.getAccount() + "\t" + account.getDebitCount() + "\t" + account.getCreditCount() + "\t" + account.getBalance() + "\n");
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading transactions file: " + e.getMessage());
        }
    }
}