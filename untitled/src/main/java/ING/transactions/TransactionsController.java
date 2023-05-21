package ING.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.*;

@RestController
public class TransactionsController {

    private final ExecutorService executorService;
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    @Autowired
    public TransactionsController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @PreDestroy
    public void preDestroy() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @PostMapping("/transactions/report")
    public List<Account> executeReport(@RequestBody List<Transaction> transactions) {
        processTransactions(transactions);

        // Sorting the accounts
        List<Account> sortedAccounts = new ArrayList<>(accounts.values());
        sortedAccounts.sort(Comparator.comparing(Account::getAccountNumber));

        return sortedAccounts;
    }

    private void processTransactions(List<Transaction> transactions) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Transaction transaction : transactions) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                String debitAccountNumber = transaction.getDebitAccount();
                String creditAccountNumber = transaction.getCreditAccount();
                double amount = transaction.getAmount();

                Account debitAccount = getOrCreateAccount(debitAccountNumber);
                Account creditAccount = getOrCreateAccount(creditAccountNumber);

                synchronized (debitAccount) {
                    debitAccount.debit(amount);
                }

                synchronized (creditAccount) {
                    creditAccount.credit(amount);
                }
            }, executorService);

            futures.add(future);
        }

        // Wait for all transactions to be processed
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    private Account getOrCreateAccount(String accountNumber) {
        return accounts.computeIfAbsent(accountNumber, Account::new);
    }
}
