package com.progressoft.induction.transactionsparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XmlTransactionParser implements TransactionParser{

    @Override
    public List<Transaction> parse(File transactionsFile) {
//        create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<Transaction> transactions = new ArrayList<>();
        try {
//            Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
//            parse the XMLfile
            Document doc = builder.parse(new File(String.valueOf(transactionsFile)));
//            Get all "Transaction" nodes from the XML
            NodeList transactionNodes = doc.getElementsByTagName("Transaction");
            for (int i = 0; i < transactionNodes.getLength(); i++) {
                Node node = transactionNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element transactionElement = (Element) node;
                    Transaction transaction = new Transaction();
//                    extract transaction details
                    String description = transactionElement.getElementsByTagName("Description").item(0).getTextContent();
                    String direction = transactionElement.getElementsByTagName("Direction").item(0).getTextContent();
                    BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(transactionElement.getElementsByTagName("Value").item(0).getTextContent()));
                    String currency = transactionElement.getElementsByTagName("Currency").item(0).getTextContent();
//                  set properties
                    transaction.setDescription(description);
                    transaction.setDirection(direction);
                    transaction.setAmount(amount);
                    transaction.setCurrency(currency);
//                    add transaction to list
                    transactions.add(transaction);
                }
            }

        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    return transactions;
    }
}