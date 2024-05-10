package com.progressoft.induction.transactionsparser.testabstract;

import com.progressoft.induction.transactionsparser.transaction.Transaction;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class TestTransactionParse {

    protected void assertTransaction(Transaction expectedTransaction, Transaction actualTransaction) {
        assertEquals(expectedTransaction.getDescription(), actualTransaction.getDescription());
        assertEquals(expectedTransaction.getDirection(), actualTransaction.getDirection());
        assertEquals(expectedTransaction.getAmount(), actualTransaction.getAmount());
        assertEquals(expectedTransaction.getCurrency(), actualTransaction.getCurrency());
    }

    protected Transaction createExpectedTransaction(String description, String direction, BigDecimal amount, String currency) {
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setDirection(direction);
        transaction.setAmount(amount);
        transaction.setCurrency(currency);
        return transaction;
    }
}
