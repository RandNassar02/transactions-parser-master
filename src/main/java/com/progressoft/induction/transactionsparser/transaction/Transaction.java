package com.progressoft.induction.transactionsparser.transaction;

import com.opencsv.bean.CsvBindByPosition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Objects;

@XmlRootElement
public class Transaction {
    @CsvBindByPosition(position = 0)
    private String description;
    @CsvBindByPosition(position = 1)
    private String direction;
    @CsvBindByPosition(position = 2)
    private BigDecimal amount;
    @CsvBindByPosition(position = 3)
    private String currency;

    public String getDescription() {
        return description;
    }
    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirection() {
        return direction;
    }
    @XmlElement
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    @XmlElement
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlElement
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "description='" + description + '\'' +
                ", direction='" + direction + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(direction, that.direction) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, direction, amount, currency);
    }
}
