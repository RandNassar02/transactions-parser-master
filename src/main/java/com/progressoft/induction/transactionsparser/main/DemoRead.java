package com.progressoft.induction.transactionsparser.main;

import com.progressoft.induction.transactionsparser.parser.CsvTransactionParser;
import com.progressoft.induction.transactionsparser.parser.XmlTransactionParser;

import java.io.File;

public class DemoRead {
    public static void main(String[] args){

//        CSVFile parsers
        File csvFile = new File( "src/main/resources/transactions.csv");
        System.out.println("CSV Transactions:");
        CsvTransactionParser csvParser = new CsvTransactionParser();
        System.out.println(csvParser.parse(csvFile));

//        XMIFile parsers
        File xmlFile = new File( "src/main/resources/transactions.xml");
        System.out.println("XML Transactions:");
        XmlTransactionParser xmlParser = new XmlTransactionParser();
        System.out.println(xmlParser.parse(xmlFile));
    }
}
