package com.progressoft.induction.transactionsparser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class CsvTransactionParser implements TransactionParser{
    @Override
    public List<Transaction> parse(File transactionsFile) {
        List<Transaction> transactions = new ArrayList<>();
        try (FileReader reader = new FileReader(transactionsFile)) {
//            create a csvReader
            CSVReader csvReader = new CSVReaderBuilder(reader).build();

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord.length >= 4) {
//                    extract transaction details
                    String description = nextRecord[0];
                    String direction = nextRecord[1];
                    BigDecimal amount = new BigDecimal(nextRecord[2]);
                    String currency = nextRecord[3];
//                    create object transaction and set properties
                    Transaction transaction = new Transaction();
                    transaction.setDescription(description);
                    transaction.setDirection(direction);
                    transaction.setAmount(amount);
                    transaction.setCurrency(currency);
//                    add transaction to list
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return transactions;
    }
}