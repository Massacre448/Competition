package ING.transactions;

public class Account {
    private String accountNumber;
    private int debitCount;
    private int creditCount;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.debitCount = 0;
        this.creditCount = 0;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebitCount() {
        return debitCount;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        balance -= amount;
        debitCount++;
    }

    public void credit(double amount) {
        balance += amount;
        creditCount++;
    }
}
