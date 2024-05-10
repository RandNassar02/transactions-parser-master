package com.progressoft.induction.transactionsparser;

import java.io.File;
import java.util.List;

public class Context {
    private TransactionParser StrategyPattern;

    public Context(TransactionParser ParseeStrategy) {
        this.StrategyPattern = ParseeStrategy;
    }

    public List<Transaction> parse(File transactionsFile){
        return StrategyPattern.parse(transactionsFile);
    }
}
