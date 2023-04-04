package com.ING.transactions;

public class Transaction {
    private long transactionId;
    private String debitAccount;
    private String creditAccount;
    private double amount;
    private boolean debit;
    private String reference;
    private double balance;

    public Transaction() {
        this.transactionId = 0;
        this.debitAccount = null;
        this.creditAccount = null;
        this.amount = 0.0;
        this.debit = false;
        this.reference = null;
        this.balance = 0.0;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public String getDebitAccount() {
        return debitAccount;
    }

    public String getCreditAccount() {
        return creditAccount;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isDebit() {
        return debit;
    }

    public String getReference() {
        return reference;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
