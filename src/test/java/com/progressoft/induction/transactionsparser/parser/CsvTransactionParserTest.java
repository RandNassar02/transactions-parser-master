package com.progressoft.induction.transactionsparser.parser;

import com.progressoft.induction.transactionsparser.testabstract.TestTransactionParse;
import com.progressoft.induction.transactionsparser.transaction.Transaction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvTransactionParserTest extends TestTransactionParse {
    @Test
    public void parseCsvContent() {
        File file = new File("src/test/resources/transactions.csv");
        CsvTransactionParser csvParser=new CsvTransactionParser();
        List<Transaction> transactions = csvParser.parse(file);
        assertNotNull(transactions);
        assertEquals(4, transactions.size());

        Transaction expectedTransaction1 = createExpectedTransaction("Cash withdrawal", "Debit", BigDecimal.valueOf(150), "JOD");
        Transaction expectedTransaction2 = createExpectedTransaction("Salary", "Credit", BigDecimal.valueOf(1000), "USD");
        Transaction expectedTransaction3 = createExpectedTransaction("Cash deposit", "Credit", BigDecimal.valueOf(22.22), "JOD");
        Transaction expectedTransaction4 = createExpectedTransaction("Bill Payment", "Debit", BigDecimal.valueOf(20), "JOD");
        assertTransaction(expectedTransaction1, transactions.get(0));
        assertTransaction(expectedTransaction2, transactions.get(1));
        assertTransaction(expectedTransaction3, transactions.get(2));
        assertTransaction(expectedTransaction4, transactions.get(3));
    }

}