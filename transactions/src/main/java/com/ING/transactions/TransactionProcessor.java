package com.ING.transactions;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class TransactionProcessor {
    /**
     * I thought about using a Bucket List, but for memory efficiency switched to a Map instead.
     *
     * This allows for O(1) lookup of accounts, which is more efficient than searching through a Bucket List for each transaction.
     *
     * When processing each transaction, the debit and credit accounts are retrieved from the Map using computeIfAbsent(),
     * which creates a new Account object if one does not already exist for the account number.
     * The transaction amount is then added or subtracted from the appropriate account's balance, and the debit and credit
     * count is incremented.
     */
    public static Map<String, Account> processTransactionsMap(List<Transaction> transactions) {
        Map<String, Account> accountMap = new HashMap<>();

        for (Transaction transaction : transactions) {
            String debitAccountNumber = transaction.getDebitAccount();
            String creditAccountNumber = transaction.getCreditAccount();
            double amount = transaction.getAmount();

            Account debitAccount = accountMap.computeIfAbsent(debitAccountNumber, Account::new);
            Account creditAccount = accountMap.computeIfAbsent(creditAccountNumber, Account::new);

            if (transaction.isDebit()) {
                debitAccount.incrementDebitCount();
                debitAccount.subtractFromBalance(amount);
            } else {
                creditAccount.incrementCreditCount();
                creditAccount.addToBalance(amount);
            }
        }

        return accountMap;
    }
}
