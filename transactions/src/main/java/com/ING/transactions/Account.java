package com.ING.transactions;

public class Account implements Comparable<Account> {
    private String account;
    private int debitCount;
    private int creditCount;
    private double balance;

    public Account(String account) {
        this.account = account;
        this.debitCount = 0;
        this.creditCount = 0;
        this.balance = 0;
    }

    public int compareTo(Account other) {
        return this.account.compareTo(other.account);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getDebitCount() {
        return debitCount;
    }

    public void setDebitCount(int debitCount) {
        this.debitCount = debitCount;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(int creditCount) {
        this.creditCount = creditCount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void incrementDebitCount() {
        debitCount++;
    }

    public void incrementCreditCount() {
        creditCount++;
    }

    public void addToBalance(double amount) {
        balance += amount;
    }


    public void subtractFromBalance(double amount) {
        balance -= amount;
    }
    public void debit(double amount) {
        balance -= amount;
        debitCount++;
    }

}