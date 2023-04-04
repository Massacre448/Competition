package com.ING.transactions;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Transaction> readTransactionsFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        Transaction[] transactionArray = objectMapper.readValue(file, Transaction[].class);
        List<Transaction> transactions = new ArrayList<>(transactionArray.length);
        Collections.addAll(transactions, transactionArray);
        return transactions;
    }


}
