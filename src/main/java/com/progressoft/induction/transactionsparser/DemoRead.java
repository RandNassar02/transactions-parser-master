package com.progressoft.induction.transactionsparser;

import java.io.File;

public class DemoRead {
    public static void main(String[] args){
        Context context;

//        CSVFile parsers
        File CSVFile = new File( "src/main/resources/transactions.csv");
        context = new Context(new CsvTransactionParser());
        System.out.println("CSV Transactions:");
        System.out.println(context.parse(CSVFile));

//        XMIFile parsers
        File XMIFile = new File( "src/main/resources/transactions.xml");
        context = new Context(new XmlTransactionParser());
        System.out.println("XML Transactions:");
        System.out.println(context.parse(XMIFile));
    }
}
