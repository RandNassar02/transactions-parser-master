package com.progressoft.induction.transactionsparser.parser;

import com.progressoft.induction.transactionsparser.transaction.Transaction;
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

public class XmlTransactionParser implements TransactionParser {

    @Override
    public List<Transaction> parse(File transactionsFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<Transaction> transactions = new ArrayList<>();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(String.valueOf(transactionsFile)));
            NodeList transactionNodes = doc.getElementsByTagName("Transaction");
            for (int i = 0; i < transactionNodes.getLength(); i++) {
                Node node = transactionNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element transactionElement = (Element) node;
                    Transaction transaction = new Transaction();
                    String description = transactionElement.getElementsByTagName("Description").item(0).getTextContent();
                    String direction = transactionElement.getElementsByTagName("Direction").item(0).getTextContent();
                    BigDecimal amount = new BigDecimal(transactionElement.getElementsByTagName("Value").item(0).getTextContent());
                    String currency = transactionElement.getElementsByTagName("Currency").item(0).getTextContent();

                    transaction.setDescription(description);
                    transaction.setDirection(direction);
                    transaction.setAmount(amount);
                    transaction.setCurrency(currency);
                    transactions.add(transaction);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
}