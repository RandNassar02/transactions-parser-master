package com.progressoft.induction.transactionsparser.parser;

import com.progressoft.induction.transactionsparser.transaction.Transaction;

import java.io.File;
import java.util.List;

public interface TransactionParser {

    List<Transaction> parse(File transactionsFile);
}
