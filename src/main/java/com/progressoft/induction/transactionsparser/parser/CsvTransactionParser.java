package com.progressoft.induction.transactionsparser.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.progressoft.induction.transactionsparser.transaction.Transaction;

import java.io.*;
import java.util.List;

public class CsvTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse (File transactionsFile) {
        try (Reader reader = new FileReader(transactionsFile)) {
            CsvToBean<Transaction> csvBuild = new CsvToBeanBuilder<Transaction>(reader)
                    .withType(Transaction.class)
                    .build();
            return csvBuild.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
